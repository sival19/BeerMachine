/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athil
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.pusher.rest.Pusher;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned;
import static com.google.common.collect.Lists.newArrayList;


public class Subscribe {
    private String endPoint = "opc.tcp://127.0.0.1";
    public static Subscribe subscribe = new Subscribe();

    public void getValues(String nodeId, String event){
        try
        {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints(endPoint).get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(endpoints.get(0));

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();

            NodeId nodeIdparse = NodeId.parse(nodeId);

            // what to read
            ReadValueId readValueId = new ReadValueId(nodeIdparse, AttributeId.Value.uid(), null, null);

            // create a subscription @ 1000ms
            UaSubscription subscription = client.getSubscriptionManager().createSubscription(1000.0).get();

            // important: client handle must be unique per item
            UInteger clientHandle = subscription.getSubscriptionId();
            MonitoringParameters parameters = new MonitoringParameters(
                    clientHandle,
                    1000.0,     // sampling interval
                    null,       // filter, null means use default
                    Unsigned.uint(10),   // queue size
                    true        // discard oldest
            );

            MonitoredItemCreateRequest request = new MonitoredItemCreateRequest(
                    readValueId, MonitoringMode.Reporting, parameters);

            List<UaMonitoredItem> items = subscription
                    .createMonitoredItems(TimestampsToReturn.Both, newArrayList(request)).get();

            // do something with the value updates
            UaMonitoredItem item = items.get(0);
            item.setValueConsumer(v -> {
                v.getValue();
                Pusher pusher = new Pusher("1296403", "bb1e7f7e02b15b9d2e7b", "77f7d6cfb7ccffdad051");
                pusher.setCluster("eu");
                pusher.setEncrypted(true);
                pusher.trigger("my-channel", event, Collections.singletonMap("message", v.getValue()));
                System.out.println(v.getValue());
            });
            Thread.sleep(5000000);
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }

    }



}

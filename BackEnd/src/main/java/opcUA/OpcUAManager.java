package opcUA;


import com.pusher.rest.Pusher;
import database.IDataManager;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class OpcUAManager implements IOPCUAManager{

    private OpcUAconnector opcUAconnector;
    private static OpcUAManager opcUAManager;
    private Variant value;

    private OpcUAManager(){this.opcUAconnector = opcUAconnector.getInstance(); }

    public static OpcUAManager getInstance() {
        if(opcUAManager==null){
            opcUAManager = new OpcUAManager();
        }
        return opcUAManager;
    }


    @Override
    public Variant readNode(String nodeID){
        OpcUaClient client = opcUAconnector.connectOPC();
        try {
            //NodeId's for each Production attribute
            NodeId readNode = NodeId.parse(nodeID);
            //DataValues for each Production attribute
            DataValue readNodeValue = client.readValue(0, TimestampsToReturn.Both, readNode).get();
            //Variant values for each Production attribute
            value = readNodeValue.getValue();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public void readWrite(){
        IOPCUAManager iopcuaManager = OpcUAManager.getInstance();

        int failed = (int)iopcuaManager.readNode("ns=6;s=::Program:Cube.Admin.ProdDefectiveCount").getValue();
        int processed = (int)iopcuaManager.readNode("ns=6;s=::Program:Cube.Admin.ProdProcessedCount").getValue();
        int currentProd = (int)iopcuaManager.readNode("ns=6;s=::Program:Cube.Admin.Parameter[0].Value").getValue();
        int stateCurrent = (int) iopcuaManager.readNode("ns=6;s=::Program:Cube.Status.StateCurrent").getValue();
        int goodProd = (int)iopcuaManager.readNode("ns=6;s=::Program:product.good").getValue();

        if(stateCurrent == 17){
            //write to DB
        }



    }

    @Override
    public Variant subscribe(String nodeId, String event){
        OpcUaClient client = opcUAconnector.connectOPC();
        try
        {
            NodeId nodeIdparse = NodeId.parse(nodeId);

            // what to read
            ReadValueId readValueId = new ReadValueId(nodeIdparse, AttributeId.Value.uid(), null, null);

            // create a subscription @ 1000ms
            UaSubscription subscription = client.getSubscriptionManager().createSubscription(1000.0).get();

            // important: client handle must be unique per item
            UInteger clientHandle = subscription.getSubscriptionId();
            MonitoringParameters parameters = new MonitoringParameters(
                    clientHandle,
                    200.0,     // sampling interval
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
                value = v.getValue();
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

        return value;
    }

    @Override
    public void writeValue(String nodeId, int value){
        try {
            OpcUaClient client = opcUAconnector.connectOPC();
            NodeId node = NodeId.parse(nodeId);
            client.writeValue(node, DataValue.valueOnly(new Variant(value))).get();
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }


    }
    @Override
    public void writeValue(String nodeId, boolean value){
        try {
            OpcUaClient client = opcUAconnector.connectOPC();
            NodeId node = NodeId.parse(nodeId);
            client.writeValue(node, DataValue.valueOnly(new Variant(value))).get();
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }


    }
    @Override
    public void writeValue(String nodeId, float value){
        try {
            OpcUaClient client = opcUAconnector.connectOPC();
            NodeId node = NodeId.parse(nodeId);
            client.writeValue(node, DataValue.valueOnly(new Variant(value))).get();
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }


    }
}
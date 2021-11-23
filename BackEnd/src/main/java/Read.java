/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.slf4j.Logger;

/**
 * @author athil
 */
public class Read {
    public static void main(String[] args) {
        try {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://192.168.0.122:4840").get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(endpoints.get(0));

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[0].Value");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId)
                    .get();
            System.out.println("DataValue= " + dataValue);

            Variant variant = dataValue.getValue();

            System.out.println("Variant= " + variant);

            float random = (float) variant.getValue();
            System.out.println("myVariable= " + random);

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }
}

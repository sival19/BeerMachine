

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athil
 */

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

public class Write {


    public static void main(String[] args) {
        URI uri;
        String host = "192.168.0.122";
//        String host = "127.0.0.1";
        int port = 4840;
        try
        {
            //opc.tcp://192.168.0.122:4840
            //opc.tcp://127.0.0.1

            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://192.168.0.122:4840").get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();

            EndpointDescription original = endpoints.get(0);
            uri = new URI(original.getEndpointUrl()).parseServerAuthority();
            String endpointURL = String.format(
                    "%s://%s:%s%s",
                    uri.getScheme(),
                    host,
                    uri.getPort(),
                    uri.getPath()
            );

            EndpointDescription endpoint = new EndpointDescription(endpointURL,
                    original.getServer(),
                    original.getServerCertificate(),
                    original.getSecurityMode(),
                    original.getSecurityPolicyUri(),
                    original.getUserIdentityTokens(),
                    original.getTransportProfileUri(),
                    original.getSecurityLevel());

            cfg.setEndpoint(endpoint);

            cfg.setEndpoint(endpoint);

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();

            //reset
            NodeId nodeId1 = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(nodeId1, DataValue.valueOnly(new Variant(1))).get();
            NodeId nodeId2 = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");
            client.writeValue(nodeId2, DataValue.valueOnly(new Variant(true))).get();

            //set batchid to 1
            NodeId nodeId3 = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[0].Value");
            client.writeValue(nodeId3, DataValue.valueOnly(new Variant((float)1.0))).get();

            //set productId to 1
            NodeId nodeId4 = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[1].Value");
            client.writeValue(nodeId4, DataValue.valueOnly(new Variant((float)2.0))).get();

            //set amount to 10k
            NodeId nodeId5 = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[2].Value");
            client.writeValue(nodeId5, DataValue.valueOnly(new Variant((float)1000.0))).get();

            //set mach speed to 200
            NodeId nodeId6 = NodeId.parse("ns=6;s=::Program:Cube.Command.MachSpeed");
            client.writeValue(nodeId6, DataValue.valueOnly(new Variant((float)37.5))).get();

            //start the shit up
            TimeUnit.SECONDS.sleep(2);
            NodeId nodeId7 = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(nodeId7, DataValue.valueOnly(new Variant(2))).get();
            NodeId nodeId8 = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");
            client.writeValue(nodeId8, DataValue.valueOnly(new Variant(true))).get();




        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }

    }
}
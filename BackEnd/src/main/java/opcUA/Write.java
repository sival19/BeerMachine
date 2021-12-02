package opcUA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

public class Write {

    private static OpcUAconnector connector = new OpcUAconnector();

    public void writeValue(String nodeId, int value){
        try {
            OpcUaClient client = connector.connectOPC();
            NodeId node = NodeId.parse(nodeId);
            client.writeValue(node, DataValue.valueOnly(new Variant(value))).get();
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }


    }
    public void writeValue(String nodeId, boolean value){
        try {
            OpcUaClient client = connector.connectOPC();
            NodeId node = NodeId.parse(nodeId);
            client.writeValue(node, DataValue.valueOnly(new Variant(value))).get();
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }


    }
    public void writeValue(String nodeId, float value){
        try {
            OpcUaClient client = connector.connectOPC();
            NodeId node = NodeId.parse(nodeId);
            client.writeValue(node, DataValue.valueOnly(new Variant(value))).get();
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }


    }
}
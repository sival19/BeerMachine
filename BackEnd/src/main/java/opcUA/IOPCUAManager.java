package opcUA;

import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

public interface IOPCUAManager {

    void writeValue(String nodeId, int value);
    void writeValue(String nodeId, float value);
    void writeValue(String nodeId, boolean value);
    Variant subscribe(String nodeId, String event);
    Variant readNode(String nodeID);
    Variant readNode(String nodeID, String event);
    void saveProduction();
    void saveSensorData(String dataType);
    void initiateCommand(int command);
    void startSequence(float batch, float productId, float amount, float speed);
}

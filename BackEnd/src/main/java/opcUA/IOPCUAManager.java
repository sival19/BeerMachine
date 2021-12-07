package opcUA;

import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

public interface IOPCUAManager {

    void writeValue(String nodeId, int value);
    void writeValue(String nodeId, float value);
    void writeValue(String nodeId, boolean value);
    Variant subscribe(String nodeId, String event);
    void saveProduction();
    Variant readNode(String nodeID);
    void initiateCommand(int command);
    void startSequence(float batch, float productId, float amount, float speed);
}

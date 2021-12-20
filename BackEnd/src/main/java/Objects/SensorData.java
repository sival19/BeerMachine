package Objects;

import java.sql.Timestamp;

public class SensorData {
    private int productionId;
    private String type;
    private float value;
    Timestamp timestamp;

    public SensorData (){}

    public SensorData (int productionId, String type, float value, Timestamp timestamp){
        this.productionId = productionId;
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getProductionId() {
        return productionId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

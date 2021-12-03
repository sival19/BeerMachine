package Objects;

import java.sql.Timestamp;

public class Production {
    private int productionSize;
    private int machineId;
    private int beerType;
    private int succeededCount;
    private int failedCount;
    private Timestamp timestamp;

    public Production(){}

    public Production(int machineId, int beerType, int productionSize, int succeededCount, int faildedCount, Timestamp timestamp){
        this.machineId = machineId;
        this.beerType = beerType;
        this.productionSize = productionSize;
        this.succeededCount = succeededCount;
        this.failedCount = faildedCount;
        this.timestamp = timestamp;
    }

    public void setProductionSize(int productionSize){
        this.productionSize = productionSize;
    }

    public void setMachineId(int machineId){
        this.machineId = machineId;
    }

    public void setBeerType(int beerType) {
        this.beerType = beerType;
    }

    public void setFailedCount(int failedCount) {
        this.failedCount = failedCount;
    }

    public void setSucceededCount(int succeededCount) {
        this.succeededCount = succeededCount;
    }

    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp;}

    public int getProductionSize(){
        return productionSize;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getBeerType() {
        return beerType;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public int getMachineId() {
        return machineId;
    }

    public int getSucceededCount() {
        return succeededCount;
    }
}


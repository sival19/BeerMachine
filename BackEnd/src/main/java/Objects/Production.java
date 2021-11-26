package Objects;

public class Production {
    private int productionSize;
    private int machineId;
    private int beerType;
    private int succeededCount;
    private int failedCount;

    public Production(){}

    public Production(int machineId, int beerType, int productionSize, int succeededCount, int faildedCount){
        this.machineId = machineId;
        this.beerType = beerType;
        this.productionSize = productionSize;
        this.succeededCount = succeededCount;
        this.failedCount = faildedCount;
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

    public int getProductionSize(){
        return productionSize;
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


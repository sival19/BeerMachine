/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

import Objects.Production;
import database.IDataManager;
import database.databaseManager;
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
    private IDataManager iDataManager;

    public void ReadAndSave(){

        iDataManager = databaseManager.getInstance();

        try {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://127.0.0.1").get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(endpoints.get(0));

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();

            //NodeId's for each Production attribute
            NodeId FailedNodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.ProdDefectiveCount");
            NodeId ProductionSizeNodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.ProdProcessedCount");
            NodeId BeerTypeNodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.Parameter[0].Value");

            //DataValues for each Production attribute
            DataValue FaileddataValue = client.readValue(0, TimestampsToReturn.Both, FailedNodeId).get();
            DataValue ProductionSizeValue = client.readValue(0, TimestampsToReturn.Both, ProductionSizeNodeId).get();
            DataValue BeerTypeValue = client.readValue(0, TimestampsToReturn.Both, BeerTypeNodeId).get();
            //System.out.println("DataValue= " + dataValue);

            //Variant values for each Production attribute
            Variant failedVariant = FaileddataValue.getValue();
            Variant ProductionSizeVariant = ProductionSizeValue.getValue();
            Variant BeerTypeVariant = BeerTypeValue.getValue();

            //System.out.println("Variant= " + variant);

            // Variant gets parsed to the required type;
            int failed = (int) failedVariant.getValue();
            int ProductionSize = (int) ProductionSizeVariant.getValue();
            //int BeerType = (int) BeerTypeValue.getValue().getValue();
            //System.out.println("myVariable= " + random);

            Production production = new Production();
            production.setProductionSize(ProductionSize);
            production.setBeerType(1);
            production.setMachineId(2);
            production.setSucceededCount(500);
            production.setFailedCount(failed);
            iDataManager.saveProduction(production);

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Read read = new Read();
        read.ReadAndSave();
    }

}

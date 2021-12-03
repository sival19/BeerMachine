/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URI;
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
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.slf4j.Logger;

/**
 * @author athil
 */
public class Read {
    private IDataManager iDataManager;
    private final String endPoint = "opc.tcp://127.0.0.1";
    //private String endPoint = "opc.tcp://192.168.0.122:4840";
    private URI uri;
    private String host = "127.0.0.1";
    //private String host = "192.168.0.122";
    private int value = 0;

    public void ReadAndSave(){

        iDataManager = databaseManager.getInstance();

        try {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints(endPoint).get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            EndpointDescription original = endpoints.get(0);

            this.uri = new URI(original.getEndpointUrl()).parseServerAuthority();
            String endpointURL = String.format(
                    "%s://%s:%s%s",
                    this.uri.getScheme(),
                    this.host,
                    this.uri.getPort(),
                    this.uri.getPath()
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

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();

            //NodeId's for each Production attribute
            NodeId FailedNodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.ProdDefectiveCount");
            NodeId ProductionSizeNodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.ProdProcessedCount");
            NodeId BeerTypeNodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.Parameter[0].Value");
            NodeId MachineIdNodeId = NodeId.parse("ns=6;s=::Program:Cube.Status.StateCurrent");
            NodeId SucceededCountNodeId = NodeId.parse("ns=6;s=::Program:product.good");

            //DataValues for each Production attribute
            DataValue FaileddataValue = client.readValue(0, TimestampsToReturn.Both, FailedNodeId).get();
            DataValue ProductionSizeValue = client.readValue(0, TimestampsToReturn.Both, ProductionSizeNodeId).get();
            DataValue BeerTypeValue = client.readValue(0, TimestampsToReturn.Both, BeerTypeNodeId).get();
            DataValue MachineIdValue = client.readValue(0, TimestampsToReturn.Both, MachineIdNodeId).get();
            DataValue SucceededCountValue = client.readValue(0, TimestampsToReturn.Both, SucceededCountNodeId).get();
            //System.out.println("DataValue= " + dataValue);

            //Variant values for each Production attribute
            Variant failedVariant = FaileddataValue.getValue();
            Variant ProductionSizeVariant = ProductionSizeValue.getValue();
            Variant BeerTypeVariant = BeerTypeValue.getValue();
            Variant MachineIdVariant = MachineIdValue.getValue();
            Variant SucceededCountVariant = SucceededCountValue.getValue();

            // Make java.lang.Float to float, for it to be type casted to integer
            float BeerTypeFloat =   (Float) BeerTypeVariant.getValue();

            // Make UInt16
            UShort SucceededCountUShort = (UShort) SucceededCountVariant.getValue();
            int SucceededCountInt = SucceededCountUShort.intValue();

            //System.out.println("Variant= " + variant);

            // Variant gets parsed to the required type;
            int failed = (int) failedVariant.getValue();
            int ProductionSize = (int) ProductionSizeVariant.getValue();
            int BeerType = (int) BeerTypeFloat + 1;
            int MachineId = 0;


            if ((int) MachineIdVariant.getValue()<= 11){
                MachineId = (int) MachineIdVariant.getValue() + 1;
            } else if ((int) MachineIdVariant.getValue() >= 15) {
                MachineId = (int) MachineIdVariant.getValue() - 2;
            }

            int SucceededCount = SucceededCountInt;
            //System.out.println("myVariable= " + random);

            Production production = new Production();
            production.setProductionSize(ProductionSize);
            production.setBeerType(BeerType);
            production.setMachineId(MachineId);
            production.setSucceededCount(SucceededCount);
            production.setFailedCount(failed);
            iDataManager.saveProduction(production);

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

    public int ReadSingleNode (String nodeID){

        iDataManager = databaseManager.getInstance();

        try {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints(endPoint).get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            EndpointDescription original = endpoints.get(0);

            this.uri = new URI(original.getEndpointUrl()).parseServerAuthority();
            String endpointURL = String.format(
                    "%s://%s:%s%s",
                    this.uri.getScheme(),
                    this.host,
                    this.uri.getPort(),
                    this.uri.getPath()
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

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();

            //NodeId's for each Production attribute
            NodeId readNode = NodeId.parse(nodeID);


            //DataValues for each Production attribute
            DataValue readNodeValue = client.readValue(0, TimestampsToReturn.Both, readNode).get();


            //Variant values for each Production attribute
            Variant readNodeVariant = readNodeValue.getValue();

            // Variant gets parsed to the required type;
            value = (int) readNodeVariant.getValue();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
        Read read = new Read();
        read.ReadAndSave();
        read.ReadSingleNode("ns=6;s=::Program:Cube.Status.StateCurrent");
    }

}

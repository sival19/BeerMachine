package opcUA;

import database.databaseConnector;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

import java.net.URI;
import java.util.List;

public class OpcUAconnector {

    private OpcUaClient client;
//    private String host = "127.0.0.1";
    private static OpcUAconnector instance;
    private String host = "192.168.0.122";


    public static OpcUAconnector getInstance(){
        if (instance == null) {
            instance = new OpcUAconnector();
        }
        return instance;
    }



    public OpcUaClient connectOPC() {

        URI uri;
        String endPoint;
        endPoint = "opc.tcp://" + host
//        +":4848"
        ;
        try {
            //opc.tcp://192.168.0.122:4840
            //opc.tcp://127.0.0.1

            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints(endPoint).get();

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

            client = OpcUaClient.create(cfg.build());
            client.connect().get();



        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }
        return client;
    }

}

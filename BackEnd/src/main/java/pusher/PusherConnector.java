package pusher;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import opcUA.OpcUAconnector;

public class PusherConnector {
    private String AppCluster = "eu";
    private String AppKey= "bb1e7f7e02b15b9d2e7b";
    private PusherOptions options = new PusherOptions().setCluster(AppCluster);
    private Pusher pusher = new Pusher(AppKey, options);

    private static PusherConnector instance;

    public static PusherConnector getInstance(){
        if (instance == null) {
            instance = new PusherConnector();
        }
        return instance;
    }

    public Pusher Connect(){
        pusher.connect(new ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange change) {
//                System.out.println("State changed to " + change.getCurrentState() +
//                        " from " + change.getPreviousState());
            }

            @Override
            public void onError(String message, String code, Exception e) {
                System.out.println("There was a problem connecting!");
            }
        }, ConnectionState.ALL);
        return pusher;
    }

}

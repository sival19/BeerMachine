import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.Pusher;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;


public class SubscribePusher {


    public static void main(String[] args) {
        String AppCluster = "eu";
        String AppKey= "bb1e7f7e02b15b9d2e7b";
        PusherOptions options = new PusherOptions().setCluster(AppCluster);
        Pusher pusher = new Pusher(AppKey, options);

        pusher.connect(new ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange change) {
                System.out.println("State changed to " + change.getCurrentState() +
                        " from " + change.getPreviousState());
            }

            @Override
            public void onError(String message, String code, Exception e) {
                System.out.println("There was a problem connecting!");
            }
        }, ConnectionState.ALL);

// Subscribe to a channel
        Channel channel = pusher.subscribe("my-channel");

// Bind to listen for events called "my-event" sent to "my-channel"
        channel.bind("production.produced", new SubscriptionEventListener() {
            @Override
            public void onEvent(PusherEvent event) {
                System.out.println("Received event with data: " + event.toString());
            }
        });

// Disconnect from the service
        pusher.disconnect();

// Reconnect, with all channel subscriptions and event bindings automatically recreated
        pusher.connect();
//        pusher.wait();
// The state change listener is notified when the connection has been re-established,
// the subscription to "my-channel" and binding on "my-event" still exist.
        while(true) ;

//        Pusher pusher = new Pusher("1296403");
//        pusher.setCluster("eu");
//        pusher.setEncrypted(true);
//        Channel channel = pusher.subscribe("my-channel");

//        pusher.trigger("my-channel", "my event", Collections.singletonMap("message", v.getValue()));
    }


}

package pusher;


import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
public class PusherManager implements IPusherManager {

    private static PusherManager pusherManager;
    private PusherConnector pusherConnector;

    private PusherManager() {
        this.pusherConnector = pusherConnector.getInstance();
    }

    public static PusherManager getInstance() {
        if (pusherManager == null) {
            pusherManager = new PusherManager();
        }
        return pusherManager;
    }
    //"App\\Events\\startProdEvent"
    @Override
    public void SubscribePusher(String eventName, SubscriptionEventListener eventListener, String theChannel) {
        Pusher pusher = pusherConnector.Connect();
        Channel channel = pusher.subscribe(theChannel);

// Bind to listen for events called "my-event" sent to "my-channel"
        channel.bind(eventName, eventListener);

// Disconnect from the service
        pusher.disconnect();

// Reconnect, with all channel subscriptions and event bindings automatically recreated
        pusher.connect();

    }


}

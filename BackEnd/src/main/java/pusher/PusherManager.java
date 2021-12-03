package pusher;


import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;

public class PusherManager implements IPusherManager {

    private static PusherManager pusherManager;
    private PusherConnector pusherConnector;

    private PusherManager(){this.pusherConnector = pusherConnector.getInstance(); }

    public static PusherManager getInstance() {
        if(pusherManager==null){
            pusherManager = new PusherManager();
        }
        return pusherManager;
    }
//"App\\Events\\startProdEvent"
    @Override
    public void SubscribePusher(String eventName){
        Pusher pusher = pusherConnector.Connect();
        Channel channel = pusher.subscribe("my-channel");

// Bind to listen for events called "my-event" sent to "my-channel"
        channel.bind(eventName, new SubscriptionEventListener() {
            @Override
            public void onEvent(PusherEvent event) {

//                JsonParser parser = new JsonParser();
//                JsonObject json = (JsonObject) parser.parse(event.getData());
//                System.out.println(json);
//                JsonElement json1 = json.getAsJsonObject("message").getAsJsonObject("value").get("value");
//                json.getAsJsonObject("message").getAsJsonObject("value").get("value");
                System.out.println("Received event with data: ");
                System.out.println(event.toString());
//                System.out.println(json1);

            }
        });

// Disconnect from the service
        pusher.disconnect();

// Reconnect, with all channel subscriptions and event bindings automatically recreated
        pusher.connect();
    }
}

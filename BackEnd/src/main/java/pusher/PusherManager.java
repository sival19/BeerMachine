package pusher;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import opcUA.IOPCUAManager;
import opcUA.OpcUAManager;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;

public class PusherManager implements IPusherManager {

    private static PusherManager pusherManager;
    private PusherConnector pusherConnector;

    private PusherEvent pusherEvent;

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
                JsonParser parser = new JsonParser();
                JsonObject json = (JsonObject) parser.parse(event.getData());
                System.out.println(json);
                float type = json.get("type").getAsFloat();
                float speed = json.get("speed").getAsFloat();
                float amount = json.get("amount").getAsFloat();
                //start production on event
                IOPCUAManager iopcuaManager = OpcUAManager.getInstance();
                iopcuaManager.startSequence(1,type,amount,speed);


            }
        });

// Disconnect from the service
        pusher.disconnect();

// Reconnect, with all channel subscriptions and event bindings automatically recreated
        pusher.connect();
    }
}

package pusher;

import com.pusher.client.channel.SubscriptionEventListener;

public interface IPusherManager {
//    void SubscribePusher(String eventName, SubscriptionEventListener eventListener);

    //"App\\Events\\startProdEvent"
    void SubscribePusher(String eventName, SubscriptionEventListener eventListener, String theChannel);
}

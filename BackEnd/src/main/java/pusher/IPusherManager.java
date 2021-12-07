package pusher;

import com.pusher.client.channel.SubscriptionEventListener;

public interface IPusherManager {
    void SubscribePusher(String eventName, SubscriptionEventListener eventListener);
}

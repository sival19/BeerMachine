package pusher;

import com.pusher.client.channel.PusherEvent;

public interface IPusherManager {
    void SubscribePusher(String eventName);
}

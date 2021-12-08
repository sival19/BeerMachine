package opcUA;

import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import pusher.IPusherManager;
import pusher.PusherManager;

public class Runner {


    public static void main(String[] args) {
        //connect to opcUA
        IOPCUAManager iopcuaManager = OpcUAManager.getInstance();
        //Listen to data from pusher
        IPusherManager iPusherManager = PusherManager.getInstance();
        //The data from pusher
        iPusherManager.SubscribePusher("App\\Events\\startProdEvent", pusherEvent -> {
            System.out.println(pusherEvent.getData());
        }, "my-channel");
        iPusherManager.SubscribePusher("App\\Events\\stopButton", pusherEvent -> {
            System.out.println(pusherEvent.getData());
        }, "stopChannel");
        iPusherManager.SubscribePusher("App\\Events\\clearButton", pusherEvent -> {
            System.out.println(pusherEvent.getData());
        }, "clearChannel");
        iPusherManager.SubscribePusher("App\\Events\\abortButton", pusherEvent -> {
            System.out.println(pusherEvent.getData());
        }, "abortChannel");
        iPusherManager.SubscribePusher("App\\Events\\resetButton", pusherEvent -> {
            System.out.println(pusherEvent.getData());
        }, "resetChannel");


        //
        iopcuaManager.initiateCommand(1);
//        iopcuaManager.startSequence(1,1,200,150);

        //read a node
//        iopcuaManager.readNode("ns=6;s=::Program:product.produced");

        //subscribe to a node
//        Thread t1 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:product.produced", "production.produced"));
//        Thread t2 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Cube.Admin.ProdDefectiveCount", "production.Defective"));
//        Thread t3 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:product.good", "production.Good"));
//        Thread t4 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.RelHumidity", "sensor.Humidity"));
//        Thread t5 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.Temperature", "sensor.Temperature"));
//        Thread t6 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.Vibration", "sensor.Vibration"));
        Thread t8 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Cube.Status.StateCurrent", "state.current"));

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
        t8.start();
    }
}

package opcUA;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import pusher.IPusherManager;
import pusher.PusherManager;

import java.util.concurrent.TimeUnit;

public class Runner {


    public static void main(String[] args) {
        //connect to opcUA
        IOPCUAManager iopcuaManager = OpcUAManager.getInstance();
        //Listen to data from pusher
        IPusherManager iPusherManager = PusherManager.getInstance();
        //The data from pusher
        iPusherManager.SubscribePusher("App\\Events\\startProdEvent", pusherEvent -> {
            System.out.println(pusherEvent.getData());
                JsonParser parser = new JsonParser();
                JsonObject json = (JsonObject) parser.parse(pusherEvent.getData());
                System.out.println(json);
                float type = json.get("type").getAsFloat();
                float speed = json.get("speed").getAsFloat();
                float amount = json.get("amount").getAsFloat();
                //start production on event
                iopcuaManager.startSequence(1,type,amount,speed);
        }, "my-channel");

//        iopcuaManager.initiateCommand(1);
//        iopcuaManager.startSequence((float) 1,(float) 0,(float) 9900,(float) 600);


        iPusherManager.SubscribePusher("App\\Events\\stopButton", pusherEvent -> {
            System.out.println(pusherEvent.getData()

            );
            iopcuaManager.initiateCommand(3);
        }, "stopChannel");

        iPusherManager.SubscribePusher("App\\Events\\clearButton", pusherEvent -> {
            System.out.println(pusherEvent.getData());
            iopcuaManager.initiateCommand(5);
        }, "clearChannel");

        iPusherManager.SubscribePusher("App\\Events\\abortButton", pusherEvent -> {
            System.out.println(pusherEvent.getData());
            iopcuaManager.initiateCommand(4);
        }, "abortChannel");

        iPusherManager.SubscribePusher("App\\Events\\resetButton", pusherEvent -> {
            System.out.println(pusherEvent.getData());
            iopcuaManager.initiateCommand(1);
        }, "resetChannel");

        iPusherManager.SubscribePusher("App\\Events\\readState", pusherEvent -> {
            System.out.println(pusherEvent.getData());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread t1 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Cube.Status.StateCurrent", "state.current"));
            t1.start();
        }, "readChannel");



        //
//        iopcuaManager.initiateCommand(1);
//        iopcuaManager.startSequence(1,1,200,150);

        //read a node
//        iopcuaManager.readNode("ns=6;s=::Program:product.produced");

        //subscribe to a node
        Thread t1 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:product.produced", "production.produced"));
        Thread t2 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Cube.Admin.ProdDefectiveCount", "production.Defective"));
        Thread t3 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:product.good", "production.Good"));
        Thread t4 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.RelHumidity", "sensor.Humidity"));
        Thread t5 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.Temperature", "sensor.Temperature"));
        Thread t6 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.Vibration", "sensor.Vibration"));
        Thread t8 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Cube.Status.StateCurrent", "state.current"));
        Thread t9 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Inventory.Yeast", "yeastAmount"));
        Thread t10 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Inventory.Barley", "barleyAmount"));
        Thread t11 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Inventory.Hops", "hopsAmount"));
        Thread t12 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Inventory.Malt", "maltAmount"));
        Thread t13 = new Thread(() -> iopcuaManager.subscribe("ns=6;s=::Program:Inventory.Wheat", "wheatAmount"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();

    }
}

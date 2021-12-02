import Objects.Production;
import database.IDataManager;
import database.databaseManager;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

public class Run implements Runnable{

    public void newSubscribe(String nodeId, String event){
        Subscribe subscribe = new Subscribe();
        subscribe.getValues(nodeId, event);
    }


    public static void main(String[] args) {

        Thread t1 = new Thread(){
            public void run () {
                Subscribe subscribe = new Subscribe();
                subscribe.getValues("ns=6;s=::Program:product.produced", "production.produced");


            }
        };
        Thread t2 = new Thread(){
                public void run () {
                    Subscribe subscribe = new Subscribe();
                    subscribe.getValues("ns=6;s=::Program:Cube.Admin.ProdDefectiveCount", "production.Defective");
                }
        };
        Thread t3 = new Thread(){
                public void run () {
                    Subscribe subscribe = new Subscribe();
                    subscribe.getValues("ns=6;s=::Program:product.good", "production.Good");
                }
        };
        Thread t4 = new Thread(){
                public void run () {
                    Subscribe subscribe = new Subscribe();
                    subscribe.getValues("ns=6;s=::Program:Data.Value.RelHumidity", "sensor.Humidity");
                }
        };

        Thread t5 = new Thread(){
                public void run () {
                    Subscribe subscribe = new Subscribe();
                    subscribe.getValues("ns=6;s=::Program:Data.Value.Temperature", "sensor.Temperature");
                }
        };
        Thread t6 = new Thread(){
                public void run () {
                    Subscribe subscribe = new Subscribe();
                    subscribe.getValues("ns=6;s=::Program:Data.Value.Vibration", "sensor.Vibration");
                }
        };

        /*
        Thread t7 = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                    Read read = new Read();
                    int count = 0;

                    if(read.ReadSingleNode("ns=6;s=::Program:Cube.Status.StateCurrent") == 17 && count<1){
                        read.ReadAndSave();
                        count++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }); */

//        Thread t7 = new Thread(){
//            public void run () {
//                Subscribe subscribe = new Subscribe();
//                if (subscribe.getValues("ns=6;s=::Program:Cube.Status.StateCurrent", "state") == 17)
//                subscribe.getValues("ns=6;s=::Program:Data.Value.Vibration", "state");
//            }
//        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        //t7.start();

    }

    @Override
    public void run() {

    }
}

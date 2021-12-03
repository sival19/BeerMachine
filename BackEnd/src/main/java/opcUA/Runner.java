package opcUA;

import database.IDataManager;
import database.databaseManager;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

import java.util.concurrent.TimeUnit;

public class Runner {


    public static void main(String[] args) {
        IOPCUAManager iopcuaManager = OpcUAManager.getInstance();
        iopcuaManager.writeValue("ns=6;s=::Program:Cube.Command.CntrlCmd",1);

        Thread t1 = new Thread(){
            public void run () {
                iopcuaManager.subscribe("ns=6;s=::Program:product.produced", "production.produced");
            }
        };
        Thread t2 = new Thread(){
            public void run () {
                iopcuaManager.subscribe("ns=6;s=::Program:Cube.Admin.ProdDefectiveCount", "production.Defective");
            }
        };
        Thread t3 = new Thread(){
            public void run () {
                iopcuaManager.subscribe("ns=6;s=::Program:product.good", "production.Good");
            }
        };
        Thread t4 = new Thread(){
            public void run () {
                iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.RelHumidity", "sensor.Humidity");
            }
        };

        Thread t5 = new Thread(){
            public void run () {
                iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.Temperature", "sensor.Temperature");
            }
        };
        Thread t6 = new Thread(){
            public void run () {
                iopcuaManager.subscribe("ns=6;s=::Program:Data.Value.Vibration", "sensor.Vibration");
            }
        };
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
//        Write write = new Write();
//        write.writeInt("ns=6;s=::Program:Cube.Command.CntrlCmd",1);
//        Write write = new Write();
//        write.writeValue("ns=6;s=::Program:Cube.Command.CntrlCmd",1);
//        write.writeValue("ns=6;s=::Program:Cube.Command.CmdChangeRequest", true);
//        write.writeValue("ns=6;s=::Program:Cube.Command.Parameter[0].Value", (float)1.0);
//        write.writeValue("ns=6;s=::Program:Cube.Command.Parameter[1].Value",(float)2.0);
//        write.writeValue("ns=6;s=::Program:Cube.Command.Parameter[2].Value", (float)1000.0);
//        write.writeValue("ns=6;s=::Program:Cube.Command.MachSpeed", (float)97.5);
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        write.writeValue("ns=6;s=::Program:Cube.Command.CntrlCmd", 2);
//        write.writeValue("ns=6;s=::Program:Cube.Command.CmdChangeRequest", true);
    }
}

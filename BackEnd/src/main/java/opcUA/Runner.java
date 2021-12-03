package opcUA;

import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) {
        Write write = new Write();
        write.writeValue("ns=6;s=::Program:Cube.Command.CntrlCmd",1);
        write.writeValue("ns=6;s=::Program:Cube.Command.CmdChangeRequest", true);
        write.writeValue("ns=6;s=::Program:Cube.Command.Parameter[0].Value", (float)1.0);
        write.writeValue("ns=6;s=::Program:Cube.Command.Parameter[1].Value",(float)2.0);
        write.writeValue("ns=6;s=::Program:Cube.Command.Parameter[2].Value", (float)1000.0);
        write.writeValue("ns=6;s=::Program:Cube.Command.MachSpeed", (float)97.5);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        write.writeValue("ns=6;s=::Program:Cube.Command.CntrlCmd", 2);
        write.writeValue("ns=6;s=::Program:Cube.Command.CmdChangeRequest", true);
    }
}

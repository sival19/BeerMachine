public class Run implements Runnable{

    public void newSubscribe(String nodeId, String event){
        Subscribe subscribe = new Subscribe();
        subscribe.getValues(nodeId, event);
    }


    public static void main(String[] args) {

                Thread t1 = new Thread(){
            public void run () {
                Subscribe subscribe = new Subscribe();
                subscribe.getValues("ns=6;s=::Program:product.produced", "my-event");
            }
        };
        Thread t2 = new Thread(){
                public void run () {
                    Subscribe subscribe = new Subscribe();
                    subscribe.getValues("ns=6;s=::Program:Cube.Command.Parameter[0].Value", "new-event");
                }
        };

        t1.start();
        t2.start();

    }

    @Override
    public void run() {

    }
}

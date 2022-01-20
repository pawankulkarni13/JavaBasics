package threads;

public class ThreadDemo{

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setName("Pawan");
        Runtime r=Runtime.getRuntime();
        System.out.println("Total Memory: "+r.totalMemory());
        System.out.println("Free Memory: "+r.freeMemory());
        for(int i=0;i<10000;i++){
            new Demo();
        }
        System.out.println("After creating 10000 instance, Free Memory: "+r.freeMemory());
        System.gc();
        System.out.println("After gc(), Free Memory: "+r.freeMemory());
        Runtime.getRuntime().addShutdownHook(new Demo());
        try{
            demo.start();
        }catch(Exception e){
            if(demo.isInterrupted()){
                System.out.println("Interupution !!!");
            }
        }

    }
}

class Demo extends Thread {

    @Override
    public void run() {
        System.out.println("Hellowwwwwww"+getName());
        System.exit(0);
    }
}

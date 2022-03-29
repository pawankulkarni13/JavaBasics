package datastructures;

//ArrayBlockingQueue implements BlockingQueue
// put and take methods are blocking methods

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(10);

        ProducerDemo producer = new ProducerDemo(queue);
        ConsumerDemo consumer = new ConsumerDemo(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}

class ProducerDemo implements Runnable{

    protected BlockingQueue queue = null;

    public ProducerDemo(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for(int i =0;i<20;i++) {
                queue.put(i);
                System.out.println("Pushing - "+ i);
//                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ConsumerDemo implements Runnable{

    protected BlockingQueue queue = null;

    public ConsumerDemo(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while(true){
                if(!queue.isEmpty()){
                    System.out.println("\t\t\t\t\tPulling - " +queue.take());}
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
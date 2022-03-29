package datastructures;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue q = new LinkedBlockingQueue(3);
        q.put(1);
        q.put(2);
        q.put(3);
        System.out.println(q);
        System.out.println(q.take());
        q.put(4);
        System.out.println(q);
        System.out.println(q.take());
        q.put(5);
        System.out.println(q);
        q.put(6); // This will be a blocking ops

    }
}

package datastructures;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue queue = new DelayQueue();

        Delayed element1 = new DelayedElement();

        queue.put(element1);

        Delayed element2 = queue.take();
        System.out.println(queue.take());

    }
}
class DelayedElement implements Delayed{

    @Override
    public long getDelay(TimeUnit unit) {
        return TimeUnit.MILLISECONDS.toMillis(10);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
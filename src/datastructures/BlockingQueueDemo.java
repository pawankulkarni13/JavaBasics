package datastructures;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A BlockingQueue is like another Queue implementations with additional capabilities.
 * Any attempt, to retrieve something out of it, can be seen safe as it will not return empty.
 * The consumer thread will automatically wait until BlockingQueue is not populated with some data.
 * Once it fills, the thread will consume the resource.
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> blockingQueue =
                new LinkedBlockingQueue<Runnable>();

        CustomThreadPoolExecutor executor =
                new CustomThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS,
                        blockingQueue, new ThreadPoolExecutor.AbortPolicy());

        // Let start all core threads initially
        executor.prestartAllCoreThreads();

        for (int i = 1; i <= 100; i++) {
            blockingQueue.offer(new DemoTask("Task " + i));
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

}

class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
                                    long keepAliveTime, TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue, AbortPolicy abortPolicy) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("Perform beforeExecute() logic");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            System.out.println("Perform exception handler logic");
        }
        System.out.println("Perform afterExecute() logic");
    }
}

class DemoTask implements Runnable {
    private String name = null;

    public DemoTask(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing : " + name);
    }
}
package threads;

public class ThreadConrolDemo {
    public static void main(String[] args) {
        RunnableDemo threadOne = new RunnableDemo( "Thread-One");
        threadOne.start();

        RunnableDemo threadTwo = new RunnableDemo( "Thread-Two");
        threadTwo.start();

        try {
            Thread.sleep(1000);
            threadOne.suspend();
            System.out.println("Suspending First Thread");
            Thread.sleep(1000);
            threadOne.resume();
            System.out.println("Resuming First Thread");

            threadTwo.suspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            threadTwo.resume();
            System.out.println("Resuming thread Two");
        }catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        try {
            System.out.println("Waiting for threads to finish.");
            threadOne.thread.join();
            threadTwo.thread.join();
        }catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");

    }
}

class RunnableDemo implements Runnable {
    public Thread thread;
    private final String threadName;
    boolean suspended = false;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 10; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(300);
                synchronized(this) {
                    while(suspended) {
                        wait();
                    }
                }
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (thread == null) {
            thread = new Thread (this, threadName);
            thread.start ();
        }
    }

    void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }
}
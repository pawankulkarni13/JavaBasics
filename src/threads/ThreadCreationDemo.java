package threads;

public class ThreadCreationDemo {
    public static void main(String[] args) {

        RunnableIntDemo threadOne = new RunnableIntDemo( "Thread-One");
        threadOne.start();

        RunnableIntDemo threadTwo = new RunnableIntDemo( "Thread-Two");
        threadTwo.start();

        ThreadClassDemo threadThree = new ThreadClassDemo( "Thread-Three");
        threadThree.start();

        ThreadClassDemo threadFour = new ThreadClassDemo( "Thread-Four");
        threadFour.start();
    }
}
class ThreadClassDemo extends Thread {

    private String threadName;

    ThreadClassDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
}

class RunnableIntDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableIntDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

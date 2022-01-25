package threads;

public class SynchronizationPrintNumbersDemo {

    public static void main(String[] args) {
        PrinterDemo printerDemo = new PrinterDemo();

        System.out.println("Without Sync");
        withoutSync(printerDemo);

        System.out.println("With Sync");
        withSync(printerDemo);
    }

    private static void withSync(PrinterDemo printerDemo) {

        ThreadWithSyncDemo threadOne = new ThreadWithSyncDemo( "Thread - One ", printerDemo );
        ThreadWithSyncDemo threadTwo = new ThreadWithSyncDemo( "Thread - Two ", printerDemo );

        threadOne.start();
        threadTwo.start();

        // wait for threads to end
        try {
            threadOne.join();
            threadTwo.join();
        }catch( Exception e) {
            System.out.println("Interrupted");
        }
    }

    private static void withoutSync(PrinterDemo printerDemo) {
        ThreadWithoutSyncDemo threadOne = new ThreadWithoutSyncDemo( "Thread - One withoutSync", printerDemo );
        ThreadWithoutSyncDemo threadTwo = new ThreadWithoutSyncDemo( "Thread - Two withoutSync", printerDemo );
        threadTwo.setPriority(10);
        threadOne.start();
        threadTwo.start();

        // wait for threads to end
        try {
            threadOne.join();
            threadTwo.join();
        }catch( Exception e) {
            System.out.println("Interrupted");
        }
    }

}

class ThreadWithoutSyncDemo extends Thread {
    private Thread t;
    private String threadName;
    PrinterDemo printerDemo;

    ThreadWithoutSyncDemo( String name, PrinterDemo printerDemo) {
        threadName = name;
        this.printerDemo = printerDemo;
    }

    public void run() {
        printerDemo.printCount();
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
class ThreadWithSyncDemo extends Thread {
    private Thread t;
    private String threadName;
    PrinterDemo printerDemo;

    ThreadWithSyncDemo( String name,  PrinterDemo printerDemo) {
        threadName = name;
        this.printerDemo = printerDemo;
    }

    public void run() {
        //Synchronization
        synchronized(printerDemo) {
            printerDemo.printCount();
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

class PrinterDemo {
    public void printCount() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Thread Name - "+Thread.currentThread().getName()+" - Counter   ---   "  + i );
            }
        }catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}
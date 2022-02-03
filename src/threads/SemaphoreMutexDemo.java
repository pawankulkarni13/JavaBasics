package threads;

import java.util.concurrent.Semaphore;

public class SemaphoreMutexDemo {

    // max 4 people
    static Semaphore semaphore = new Semaphore(4);

    static class MyThread extends Thread {

        String name = "";

        MyThread(String name) {
            this.name = name;
        }

        public void run() {

            try {


                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : is performing operation " + i
                                + ", available Semaphore permits : "
                                + semaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Total available Semaphore permits : "
                + semaphore.availablePermits());

        MyThread t1 = new MyThread("A");
        t1.start();

        MyThread t2 = new MyThread("B");
        t2.start();

        MyThread t3 = new MyThread("C");
        t3.start();

        MyThread t4 = new MyThread("D");
        t4.start();

        MyThread t5 = new MyThread("E");
        t5.setPriority(10);
        t5.start();

        MyThread t6 = new MyThread("F");
        t6.setPriority(8);
        t6.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();

        System.out.println("MUTEX ! ---------------------\n Total available Semaphore permits : "
                + semaphore.availablePermits());

        MyLockerThread tl1 = new MyLockerThread("A");
        tl1.start();

        MyLockerThread tl2 = new MyLockerThread("B");
        tl2.start();

        MyLockerThread tl3 = new MyLockerThread("C");
        tl3.setPriority(10);
        tl3.start();

        MyLockerThread tl4 = new MyLockerThread("D");
        tl4.start();

        MyLockerThread tl5 = new MyLockerThread("E");
        tl5.setPriority(10);
        tl5.start();

        MyLockerThread tl6 = new MyLockerThread("F");
        tl6.start();
    }
    // max 1 people
    static Semaphore oneSemaphore = new Semaphore(1);

    static class MyLockerThread extends Thread {

        String name = "";

        MyLockerThread(String name) {
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: "
                        + oneSemaphore.availablePermits());

                oneSemaphore.acquire();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : is performing operation " + i
                                + ", available Semaphore permits : "
                                + oneSemaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);
                    }
                } finally {
                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    oneSemaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "
                            + oneSemaphore.availablePermits());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

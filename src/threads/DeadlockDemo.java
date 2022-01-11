package threads;

public class DeadlockDemo {

    static Object object1 = new Object();
    static Object object2 = new Object();

    private static class ThreadOne extends Thread {
        public void run() {
            synchronized (object1) {
                System.out.println("Thread 1: Has  ObjectLock1");
            /* Adding sleep() method so that
               Thread 2 can lock ObjectLock2 */
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for ObjectLock 2");
            /*Thread 1 has ObjectLock1
              but waiting for ObjectLock2*/
                synchronized (object2) {
                    System.out.println("Thread 1: No DeadLock");
                }
            }
        }
    }
    private static class ThreadTwo extends Thread {
        public void run() {
            synchronized (object2) {
                System.out.println("Thread 2: Has  ObjectLock2");
            /* Adding sleep() method so that
               Thread 1 can lock ObjectLock1 */
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for ObjectLock 1");
            /*Thread 2 has ObjectLock2
              but waiting for ObjectLock1*/
                synchronized (object1) {
                    System.out.println("Thread 2: No DeadLock");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadOne thread1 = new ThreadOne();
        ThreadTwo thread2 = new ThreadTwo();
        thread1.start();
        thread2.start();
//        Thread.currentThread().join(100); // How to avoid it or cancel it ?
    }

//    To get the Thread PID
//    cmd > jps   // 9004 ClassName
//    cmd > jcmd 9004 Thread.print

}

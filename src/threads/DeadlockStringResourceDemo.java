package threads;

public class DeadlockStringResourceDemo {

    public static void main(String[] args) {

        final String firstName = "Pawan";
        final String lastName ="Kulkarni";

        System.out.println("Deadlock Demo Starts");

        Thread t1= new Thread(){
            public void run() {
                synchronized (firstName) {
                    System.out.println("1 Locking on firstName" + Thread.currentThread().getName());

                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1 Trying to access lastname" + Thread.currentThread().getName());
                    synchronized (lastName) {
                        System.out.println("1 Locking on lastName" + Thread.currentThread().getName());
                    }
                }
            }
        };

        Thread t2= new Thread(){
            public void run() {
                synchronized (lastName) {
                    System.out.println("2 Locking on lastName" + Thread.currentThread().getName());

                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2 Trying to access firstName" + Thread.currentThread().getName());
                    synchronized (firstName) {
                        System.out.println("2 Locking on firstName" + Thread.currentThread().getName());
                    }
                }
            }
        };

        t1.start();
        t2.start();

        System.out.println("End of Code - Never/Ever executed ?"+Thread.currentThread().getName());
    }

}
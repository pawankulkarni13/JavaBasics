package threads;

public class SynchronizationDemo {

    public static void main(String[] args) {
        System.out.println("Hello");
        Tables tables = new Tables();
        SimpleThread t1 = new SimpleThread(tables,5);
        SimpleThread2 t2 = new SimpleThread2(tables,50);
        t1.start();
        t2.start();
    }
}

class Tables{
    //Static usage on printTables method
    // synchronized static void printTables(int n)
    void printTables(int n){
        System.out.println("Entering Sync Block"+Thread.currentThread().getName());
        synchronized (this){
            System.out.println("Entered Sync Block-1"+Thread.currentThread().getName());
            for(int i=1;i<=10;i++){

                System.out.println(Thread.currentThread().getName() + "" + n * i);
            }
        }
        System.out.println("Leaving Sync Block"+Thread.currentThread().getName());
    }
    /*synchronized void printTables(int n){
        System.out.println("Entering Sync Block"+Thread.currentThread().getName());
//        synchronized (this){
            System.out.println("Entered Sync Block-1"+Thread.currentThread().getName());
            for(int i=1;i<=10;i++){

                System.out.println(Thread.currentThread().getName() + "" + n * i);
            }
//        }
        System.out.println("Leaving Sync Block"+Thread.currentThread().getName());
    }*/
}

class SimpleThread extends Thread{

    Tables tables;
    int n;
    SimpleThread(Tables t,int n){
        this.tables = t;
        this.n =n;
    }

    @Override
    public void run() {
        tables.printTables(n);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SimpleThread2 extends Thread{

    Tables tables;
    int n;
    SimpleThread2(Tables t,int n){
        tables = t;
        this.n =n;
    }

    @Override
    public void run() {
        tables.printTables(n);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
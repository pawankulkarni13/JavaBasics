package threads;

public class EvenOddPrintDemo {
    static int MAX = 5;

    public static void main(String... args) {
        NumberPrinter print = new NumberPrinter();

        Thread t1 = new Thread(new EvenOdd(print, MAX, false));
        Thread t2 = new Thread(new EvenOdd(print, MAX, true));
        t1.start();
        t2.start();
    }
}

class EvenOdd implements Runnable {

    private int max;
    private NumberPrinter numberPrinter;
    private boolean isEven;

    EvenOdd(NumberPrinter numberPrinter, int max, boolean isEven) {
        this.numberPrinter = numberPrinter;
        this.max = max;
        this.isEven = isEven;
    }

    @Override
    public void run() {

        int number = isEven == true ? 2 : 1;
        while (number <= max) {

            if (isEven) {
                //System.out.println("Thread Even: "+ Thread.currentThread().getName());
                numberPrinter.printEven(number);
            } else {
                //System.out.println("Thread Odd: "+ Thread.currentThread().getName());
                numberPrinter.printOdd(number);
            }
            number += 2;
        }
    }
}

class NumberPrinter {

    boolean isOdd = false;

    synchronized void printEven(int number) {

        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread Even: " + number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread Odd: " + number);
        isOdd = true;
        notifyAll();
    }
}

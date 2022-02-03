package threads;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternateDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread();
        Thread threadTwo = new Thread();

        FooBar fooBar = new FooBar(2);
        fooBar.foo(threadOne);
        fooBar.foo(threadTwo);

    }
}

class FooBar {
    private int n;
    Semaphore s = new Semaphore(0);
    Semaphore s2 = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            s2.acquire();

            printFoo.run();
            s.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            s.acquire();

            printBar.run();
            s2.release();

        }
    }
}

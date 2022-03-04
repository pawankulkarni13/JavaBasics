package threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask[] randomNoTasks = new FutureTask[10];
        for (int j = 0; j < 10; j++) {
            Callable cal = new CallableExample();

            randomNoTasks[j] = new FutureTask(cal);

            Thread th = new Thread(randomNoTasks[j]);
            th.start();
        }

        for (int j = 0; j < 10; j++) {
            Object o = randomNoTasks[j].get();

            System.out.println("The random number is: " + o);
        }
    }
}
class CallableExample implements Callable {

    @Override
    public Object call() throws Exception {
        // Create random number generator
        Random generator = new Random();

        int randomNumber = generator.nextInt(5);

        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }
}
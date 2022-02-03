package threads;

import java.util.LinkedList;

public class ProducerConsumerSimpleDemo {

    public static void main(String[] args) throws InterruptedException {
        final ProducerConsumer pc = new ProducerConsumer();
        //this contains both producer and consumer.

        //Lets create Producer and Consumer Threads and start them.
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
    }

    public static class ProducerConsumer {
        // Create a list shared by producer and consumer
        // Size of list is capacity.
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 3;

        // Function called by producer thread
        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    // producer thread waits while list
                    // is full
                    while (list.size() == capacity) {
                        System.out.println("-------------------Producer Capacity - Full List-------------------");
                        wait();
                    }

                    System.out.println("Producer produced- " + value);

                    // to insert the jobs in the list
                    list.add(value++);

                    // notifies the consumer thread that
                    // now it can start consuming
                    notify();

                    // makes the working of program easier
                    // to understand
                    Thread.sleep(1000);
                }
            }
        }

        // Function called by consumer thread
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // consumer thread waits while list
                    // is empty
                    while (list.size() == 0) {
                        System.out.println("-------------------Consumer Waiting - Empty List-------------------");
                        wait();
                    }

                    //to retrive the ifrst job in the list
                    int val = list.removeFirst();

                    System.out.println("\t \t \t \t \t Consumer consumed-" + val);

                    // Wake up producer thread
                    notify();

                    // and sleep
                    Thread.sleep(1000);
                }
            }
        }
    }
}

package datastructures;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        //put 5 elements to the queue using add
        for (int i = 5; i > 0; i--) {
            priorityQueue.add(i);
        }
        System.out.println("the head of the queue = " + priorityQueue.peek());
        //removing element by element from the queue using poll and print it out
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
        //put 5 new elements into the empty queue using offer
        for (int i = 10; i > 5; i--) {
            priorityQueue.offer(i);
        }
        System.out.println("now the head of the queue = " + priorityQueue.peek());
        System.out.println("the queue before removing 9:");
        System.out.println(priorityQueue);
        priorityQueue.remove(9);
        System.out.println("the queue after removing 9:");
        System.out.println(priorityQueue);
        //removing all the elements from the queue
        priorityQueue.clear();
        System.out.println(priorityQueue);
        //trying to print out the head of the empty Queue using peek - we'll get null
        System.out.println(priorityQueue.peek());
        //trying to print out the head of the empty Queue using element - we'll get the exception
        System.out.println(priorityQueue.element());
    }
}

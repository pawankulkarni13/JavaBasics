package datastructures;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A PriorityQueue is used when the objects are supposed to be processed based on the priority.
 * It is known that a Queue follows the First-In-First-Out algorithm, but sometimes the elements of the queue are
 * needed to be processed according to the priority, that’s when the PriorityQueue comes into play.
 * The PriorityQueue is based on the priority heap.
 * The elements of the priority queue are ordered according to the natural ordering,
 * or by a Comparator provided at queue construction time, depending on which constructor is used.
 *
 * The front of the priority queue contains the least element according to the specified ordering,
 * and the rear of the priority queue contains the greatest element.
 * When you remove an element from the priority queue,
 * the least element according to the specified ordering is removed first.
 * Note that this implementation is not synchronized.
 * Multiple threads should not access a PriorityQueue instance concurrently if any of the threads modifies the queue.
 * Instead, use the thread-safe PriorityBlockingQueue class.
 */

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
//        System.out.println(priorityQueue.element());

        Queue<String> priorityQueueS = new PriorityQueue<>(Comparator.naturalOrder());
        priorityQueueS.add("Pawan");
        priorityQueueS.add("Kulkarni");
        priorityQueueS.add("Jan");
        priorityQueueS.add("Feb");
        priorityQueueS.add("Zee");
        priorityQueueS.add("March");
        priorityQueueS.add("April");
        priorityQueueS.add("Apple");
        System.out.println(priorityQueueS);
        priorityQueueS.add("");//Valid
        System.out.println(priorityQueueS);
        priorityQueueS.add(null);
        while (!priorityQueueS.isEmpty()) {
            System.out.println(priorityQueueS.remove());
        }
    }
}

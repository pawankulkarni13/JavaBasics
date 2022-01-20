package datastructures;

import java.util.ArrayDeque;

public class ArrayDequeDemo {


    /*
     *ArrayDeque <E> class is a general two directional queue,
     * inheriting functionality from the AbstractCollection class and using the Deque interface.
     * ArrayDeque provides the facility of using deque and resizable-array.
     * Initially, the array is initialized with size 16.
     * It is implemented as a two-way queue, where it supports two pointers, namely the head and tail.
     * It inherits AbstractCollection class and implements the Deque interface.
     * The important points about ArrayDeque class are: You can add or remove elements from the tail and the head of the ArrayDeque
     * Null elements are not allowed
     * ArrayDeque is not thread safe, in the absence of external synchronization.
     * ArrayDeque has no capacity restrictions.
     */

    public static void main(String[] args) {

        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add("10");
        arrayDeque.addFirst("11");
        arrayDeque.addLast("12");
        arrayDeque.add("13");
        arrayDeque.addFirst("14");
        arrayDeque.addLast("15");
        arrayDeque.offer("16");
        arrayDeque.offerFirst("17");
        arrayDeque.offerLast("18");
        arrayDeque.offerLast("10");

        arrayDeque.removeFirstOccurrence("10");
        System.out.println(arrayDeque);

    }
}

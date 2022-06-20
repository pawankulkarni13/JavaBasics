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

    static void test(Object o){
        System.out.println("object");
    }
    static void test(ArrayDeque o){
        System.out.println("array");
    }
    public static void main(String[] args) {


//        ArrayDeque arrayDeque = new ArrayDeque();
//        arrayDeque.add("10");
//        arrayDeque.addFirst("11");
//        arrayDeque.addLast("12");
//        arrayDeque.add("13");
//        arrayDeque.addFirst("14");
//        arrayDeque.addLast("15");
//        arrayDeque.offer("16");
//        arrayDeque.offerFirst("17");
//        arrayDeque.offerLast("18");
//        arrayDeque.offerLast("10");
//
//        arrayDeque.removeFirstOccurrence("10");
//        System.out.println(arrayDeque);

        LRU lru = new LRU(3);
        lru.add(3);
        lru.add(6);
        lru.add(9);
        System.out.println(lru.queue);
        lru.get(9);
        System.out.println(lru.queue);
        lru.add(10);
        System.out.println(lru.queue);

    }
}
class LRU {
    ArrayDeque<Integer> queue ;
    int capacity;

    LRU(int cap){
        capacity= cap;
        queue = new ArrayDeque<Integer>();
    }

    public void add(int data){
        if(queue.size() == capacity){
            System.out.println("Removing Last Recently Used");
            queue.removeLast();
            queue.addFirst(data);
        }else{
            queue.add(data);
        }
    }
    public int get(int data){
        if(queue.contains(data)){
            queue.remove(data);
            queue.addFirst(data);
        }
        return 0;
    }
}



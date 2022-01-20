package datastructures;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        System.out.println("Hello");

        //PriorityQueue, Deque, and ArrayDeque
        Queue<String> q1 = new PriorityQueue();
        Queue<String> q2 = new ArrayDeque();

        q1.add("pawan");
        q1.add("abc");
        q1.add("xyz");
        q1.add("zab");
        q1.add("test01");
        q1.add("test02");
        System.out.println(q1);

        q2.add("pawan");
        q2.add("abc");
        q2.add("xyz");
        q2.add("zab");
        q2.add("test01");
        q2.add("test02");

        System.out.println(q2);

    }
}
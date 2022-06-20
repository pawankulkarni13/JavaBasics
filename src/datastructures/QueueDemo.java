package datastructures;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        System.out.println("Hello");

        priorityQueueWithNumbers();
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

    private static void priorityQueueWithNumbers() {
        Queue<Integer> q1 = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o1.compareTo(o2);
            }
        });

        q1.add(100);
        q1.add(50);
        q1.add(90);
        q1.add(10);
        q1.add(20);
        q1.add(40);
        q1.add(80);
        q1.add(60);
        System.out.println("Priority Queue Elements - " );
        while(q1.size() != 0) {
            System.out.print(q1.poll()+",");
        }
        System.out.println();
    }
}
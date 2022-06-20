package datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("pawan");
        list.add("test");
        list.add("temp");
        list.add("arraylist");
        list.add("linkedlist");
        list.add(0,"first");
        System.out.println(list);
        System.out.println(list.element());


        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

        System.out.println(ll);
        System.out.println(ll.element());

        Map map = new HashMap<>();
        map.put(3,"3");
        map.put(1,"1");
        map.put(2,"2");
        map.keySet().stream().sorted().close();
        System.out.println(map);
    }
}

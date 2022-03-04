package datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LinkedListDemo {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("pawan");
        list.add("test");
        list.add("temp");
        list.add("arraylist");
        list.add("linkedlist");
        list.add(0,"first");
        System.out.println(list);

        Map map = new HashMap<>();
        map.put(3,"3");
        map.put(1,"1");
        map.put(2,"2");
        map.keySet().stream().sorted().close();
        System.out.println(map);
    }
}

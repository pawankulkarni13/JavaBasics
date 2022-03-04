package datastructures;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("pawan");
        list.add("test");
        list.add("temp");
        list.add("arraylist");
        list.add("linkedlist");
        list.add(0, "First");
        System.out.println(list);

        list.subList(1, 3).clear();

        System.out.println(list);

//        ArrayList newlist = new ArrayList();
//        newlist.addAll(list);
//
//        ((ArrayList<?>) newlist).removeRange(2, 4);
//
//        System.out.println(newlist);
    }
}

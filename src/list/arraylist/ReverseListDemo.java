package list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseListDemo {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");

        System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        //Heterogeneous collection.
        List arrList = new ArrayList();
        arrList.add(1);
        arrList.add('1');
        arrList.add("1");

        System.out.println(arrList);
    }
}

package datastructures;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {
        System.out.println("Hello");

        List<String> vector = new Vector<>();
        vector.add("pawan");
        vector.add("abc");
        vector.add("zzzzzzzzzzz");
        vector.add("xyz");
        vector.add("IBM");
        vector.add("CGI");

        System.out.println(vector);

        Iterator<String> itr = vector.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
package datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HashSetDemo {

    public static void main(String[] args) {
        sortDemo();
    }

    private static void sortDemo() {
        Set set = new HashSet();
        set.add("pawan");
        set.add("abc");
        set.add("test");
        set.add("zn");
        set.add("hzn");
        System.out.println(set);

        set = (Set) set.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
    }
}

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
        Set<String> set = new HashSet<>();
        set.add("pawan");
        set.add("abc");
        set.add("test");
        set.add("zn");
        set.add("hzn");
//        set.add
        System.out.println(set);
//        set.stream().filter(rec-> rec.startsWith("p")).findFirst().isPresent();
        set = (Set) set.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
        set.stream().filter(rec-> rec.charAt(0) == 'a').findFirst();
        System.out.println(Integer.valueOf('a'));
    }
}

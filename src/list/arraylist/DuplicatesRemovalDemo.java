package list.arraylist;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesRemovalDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 10, 1, 2, 2, 3, 10, 3, 3, 4, 5, 5));

        System.out.println("ArrayList with duplicates: "+ list);

        List<Integer> uniqueList = list.stream().distinct().collect(Collectors.toList());

        System.out.println("ArrayList without duplicates : "+ uniqueList);

    }
}

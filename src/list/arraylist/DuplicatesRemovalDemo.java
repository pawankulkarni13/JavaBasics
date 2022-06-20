package list.arraylist;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicatesRemovalDemo {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1,1,10, 1, 2, 2, 3, 10, 3, 3, 4, 5, 5,10,10,10,10));
//
//        int [] arr= {1,3,5,6,7,6,};
////        Map map =   (Map) Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        System.out.println(map);
//        System.out.println("ArrayList with duplicates: "+ list);
//        String input = "Mango,Orange,Mango,Apple";
//
//        List<Integer> uniqueList = list.stream().distinct().collect(Collectors.toList());
//
//        System.out.println("ArrayList without duplicates : "+ uniqueList);
//        Map map = findFrequencyOfElements(list);
//        System.out.println(map.entrySet());
    }

    private static Map findFrequencyOfElements(List<Integer> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}

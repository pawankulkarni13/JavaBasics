package datastructures;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        String input = "Mango,Orange,Mango,Apple";
        Map<String, Long> freqMap = Arrays.stream(input.split(",")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        freqMap.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .sorted(Map.Entry.comparingByKey())
//                .forEach(System.out::println);
        freqMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue().stream().map(Map.Entry::getKey).collect(Collectors.joining(", "))));

         TreeMap<String, Long> freq = new TreeMap<>(freqMap);
        System.out.println(freq.entrySet());

//        ArrayList newlist = new ArrayList();
//        newlist.addAll(list);
//
//        ((ArrayList<?>) newlist).removeRange(2, 4);
//
//        System.out.println(newlist);


        String s = "abcdeart";
        int[] visited = new int[256];
        int count = 0;
        Arrays.fill(visited, -1);
        int j=0;
        for(int i=0;i<s.length();i++){
            j= Math.max(j, visited[s.charAt(i)] +1);
            count = Math.max(count, i-j+1);
            visited[s.charAt(i)] = i;

        }
        System.out.println(count);
    }
}
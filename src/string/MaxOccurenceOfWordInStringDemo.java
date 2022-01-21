package string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxOccurenceOfWordInStringDemo {
    public static void main(String[] args) {
        String s = "My name is Pawan My country is India My fav language is Java My nationality is Indian My My My ";
        maxOccurence(s);
    }

    private static void maxOccurence(String s) {

        String [] strings = s.split(" ");
        Map<String, Long> result = Arrays.stream(strings).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long maxOcc = result.values().stream().max(Long::compare).get();

        System.out.println(maxOcc);
        String key = result.entrySet().stream().filter(rec-> (result.get(rec.getKey()) == maxOcc)).findFirst().get().getKey();

        System.out.println("Max Word Occuring is -- " + key + " --Occurences -- "+ maxOcc);


    }
}
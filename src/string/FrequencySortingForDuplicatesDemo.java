package string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given comma separated words you have to sort words based on frequency in descending order,
 * if word frequency are same then sort based on String in ascending order.
 *
 * Ex 1:
 * String input = "Mango,Orange,Mango,Apple,Orange,Mango"
 * Output :
 * Mango : 3
 * Orange :2
 * Apple :1
 *
 *
 * Ex 2:
 * String input = "Mango,Orange,Mango,Apple"
 * Output :
 * Mango : 2
 * Apple :1
 * Orange :1
 */
public class FrequencySortingForDuplicatesDemo {

    public static void main (String[] args) {

        String input = "Mango,Orange,Mango,Apple";
        Map<String, Long> freqMap = Arrays.stream(input.split(",")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        freqMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue().stream().map(Map.Entry::getKey).collect(Collectors.joining(", "))));

    }

}

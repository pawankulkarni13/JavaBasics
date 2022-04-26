package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateElementsStream {

    //How to find duplicate elements in a Stream in Java
    //Given a stream containing some elements, the task is to find the duplicate elements in this stream in Java.
    //
    //Examples:
    //
    //Input: Stream = {5, 13, 4, 21, 13, 27, 2, 59, 59, 34}
    //Output: [59, 13]
    //Explanation:
    //The only duplicate elements in the given stream are 59 and 13.
    //
    //Input: Stream = {5, 13, 4, 21, 27, 2, 59, 34}
    //Output: []
    //Explanation:
    //There are no duplicate elements in the given stream, hence the output is empty.

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);

        System.out.println(duplicateElements(stream));

        stream = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        System.out.println(duplicateElementsWithoutSet(stream));

        List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        System.out.println(duplicateElementsWithFrequency(list));
    }

    private static List<Integer> duplicateElements(Stream<Integer> stream) {
        Set set = new HashSet<>();
        return stream.filter(n->!set.add(n)).collect(Collectors.toList());
    }
    private static Set<Integer> duplicateElementsWithoutSet(Stream<Integer> stream) {
        stream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        return stream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(m -> m.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
    }
    private static Set<Integer> duplicateElementsWithFrequency(List<Integer> list) {
        return list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet());
    }

}

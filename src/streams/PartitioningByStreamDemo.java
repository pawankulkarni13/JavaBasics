package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByStreamDemo {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        Map<Boolean, List<Integer>> evenNumberMap = numberList.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("The Even Numbers are" + evenNumberMap.get(true));
        System.out.println("The Odd Numbers are" + evenNumberMap.get(false));

        Map<Boolean, List<Integer>> gt5Map = numberList.stream()
                .collect(Collectors.partitioningBy(num -> num >= 5));
        System.out.println("The Numbers Greater than or equal to 5 are" + gt5Map.get(true));
        System.out.println("The Numbers Less than 5 are" + gt5Map.get(false));


        Map<Boolean, Map<Boolean, List<Integer>>> gte5EvenOddMap = numberList.stream()
                .collect(Collectors.partitioningBy(
                        num -> num >= 5,
                        Collectors.partitioningBy(
                                num -> num % 2 == 0
                        )
                ));
        System.out.println("Odd numbers Greater than 5  are "
                + gte5EvenOddMap.get(true).get(false));
        System.out.println("Even numbers Greater than 5  are "
                + gte5EvenOddMap.get(true).get(true));
        System.out.println("Even numbers Less than 5  are "
                + gte5EvenOddMap.get(false).get(true));
    }
}

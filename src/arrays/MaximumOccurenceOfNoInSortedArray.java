package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a sorted array and a number write a method that returns the number of occurances of given number
 */
public class MaximumOccurenceOfNoInSortedArray {
    public static void main(String[] args) {

        int numbers[] = {5, 8, 2, 4, 5, 6, 3, 4, 2, 5, 6, 5, 9, 8, 6, 2, 1};

        numbers = sortArray(numbers);

        int occu = findMaxOccOfNo(numbers , 5);
        System.out.println("Occurence of 5 - "+ occu);

        occu = findMaxOccOfNo(numbers , 1);
        System.out.println("Occurence of 1 - "+ occu);

    }

    private static int findMaxOccOfNo(int[] numbers, int i) {
        Map<Integer, Integer> result = new HashMap<>(numbers.length);

        for (int j = 0; j < numbers.length; j++) {
            if(result.containsKey(numbers[j])){
                result.put(numbers[j], result.get(numbers[j])+1);
            }else{
                result.put(numbers[j], 1);
            }
        }
        return result.get(i);
    }

    private static int[] sortArray(int[] numbers) {
        return Arrays.stream(numbers).sorted().toArray();
    }
}

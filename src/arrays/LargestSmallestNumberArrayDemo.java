package arrays;

import java.util.Arrays;

public class LargestSmallestNumberArrayDemo {
    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};

        int largestNumber = Arrays.stream(numbers).max().getAsInt();
        int smallestNumber = Arrays.stream(numbers).min().getAsInt();

        System.out.println("Largest Number is - " + largestNumber);
        System.out.println("Smallest Number is - " + smallestNumber);

        System.out.println("Largest Number is - " + findMax(numbers));

        System.out.println("Largest Number and Smallest Number Using Code");
        findMaxMin(numbers);
    }

    private static void findMaxMin(int[] numbers) {
        int smallest = numbers[0];
        int largetst = numbers[0];

        for(int i=1; i< numbers.length; i++)
        {
            if(numbers[i] > largetst)
                largetst = numbers[i];
            else if (numbers[i] < smallest)
                smallest = numbers[i];

        }

        System.out.println("Largest Number is : " + largetst);
        System.out.println("Smallest Number is : " + smallest);
    }

    public static int findMax(int[] arr) {
        return Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
    }
}

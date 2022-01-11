package arrays;

import java.util.Arrays;

public class LargestSmallestNumberArrayDemo {
    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};

        int largestNumber = Arrays.stream(numbers).max().getAsInt();
        int smallestNumber = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Largest Number is - " + largestNumber);
        System.out.println("Smallest Number is - " + smallestNumber);

    }
}

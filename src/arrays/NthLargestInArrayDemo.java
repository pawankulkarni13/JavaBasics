package arrays;

import java.util.Arrays;
import java.util.Collections;

public class NthLargestInArrayDemo {

    public static void print2largest(int arr[], int arr_size) {
        int i, first, second;

        /* There should be atleast two elements */
        if (arr_size < 2) {
            System.out.print(" Invalid Input ");
            return;
        }

        first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr_size; i++) {
            /* If current element is smaller than
            first then update both first and second */
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and
               second then update second  */
            else if (arr[i] > second && arr[i] != first)
                second = arr[i];
        }

        if (second == Integer.MIN_VALUE)
            System.out.print("There is no second largest element\n");
        else
            System.out.print("The second largest element is " + second);
    }

    public static void main(String[] args) {
        int arr[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};
        int n = arr.length;
        print2largest(arr, n);
        System.out.println();
        int val = findLargest(arr, 2);
        System.out.println("Second Largest is "+val);

        System.out.println("Find nth Largest");
        val = findLargest(arr, arr.length-2);
        System.out.println(arr.length-2+" Largest is "+val);
    }

    private static int findLargest(int[] arr, int i) {
        int[] arrDesc = Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

//        Arrays.sort(new int[][]{arr}, Collections.reverseOrder());
        return arrDesc[i-1];
    }
}

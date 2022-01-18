package sorting;

import java.util.Arrays;

public class CountingSortDemo {
    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};
        countingSort(numbers);
        print(numbers);
    }

    private static void print(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " - ");
        }
        System.out.println();
    }
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int [] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int cur = arr[i];
            sorted[count[cur] - 1] = cur;
            count[cur]--;
        }

        int index = 0;
        for (int num : sorted) {
            arr[index++] = num;
        }
    }
}

package sorting;

public class QuickSortDemo {

    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};
        quickSort(numbers, 0, numbers.length-3);    //97 and 6 at end will not be considered for Sorting.
        print(numbers);
    }

    private static void print(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " - ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pivotIndex = left + (right - left) / 2;
        int pivotValue = arr[pivotIndex];
        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i] < pivotValue) {
                i++;
            }
            while (arr[j] > pivotValue) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
            if (left < i) {
                quickSort(arr, left, j);
            }
            if (right > i) {
                quickSort(arr, i, right);
            }
        }
    }
}

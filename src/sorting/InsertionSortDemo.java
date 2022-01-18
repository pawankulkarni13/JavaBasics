package sorting;

public class InsertionSortDemo {
    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};
        insertionSort(numbers);
        print(numbers);
    }

    private static void print(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " - ");
        }
        System.out.println();
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }
}

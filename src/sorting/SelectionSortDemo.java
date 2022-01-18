package sorting;

public class SelectionSortDemo {

    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};
        selectionSort(numbers);
        print(numbers);
    }

    private static void print(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " - ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }
}

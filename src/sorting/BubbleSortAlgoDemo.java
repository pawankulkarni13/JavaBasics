package sorting;

public class BubbleSortAlgoDemo {
    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};
        bubbleSort(numbers);
        print(numbers);
    }

    private static void print(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " - ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int lastIndex = arr.length - 1;

        for (int j = 0; j < lastIndex; j++) {
            for (int i = 0; i < lastIndex - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
    }
}

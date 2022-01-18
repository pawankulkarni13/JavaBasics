package arrays;

public class ReverseArrayDemo {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        reverseArray(arr);
        print(arr);
    }

    private static void reverseArray(int[] arr) {
        int start =0;
        int end = arr.length-1;
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void print(int[] arr) {
        for (int a : arr){
            System.out.print(a + " - ");
        }
        System.out.println();
    }
}

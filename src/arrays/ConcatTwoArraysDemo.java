package arrays;

import java.util.Arrays;

public class ConcatTwoArraysDemo {

    public static void main(String[] args) {
        Integer in[] = {10,20,30};
        System.out.println(Arrays.toString(in));
        int numberArrOne[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};
        int numberArrTwo[] = {10, 20, 30, 40, 50};
        int numberArrThree[] = {100, 200, 300};

        int result [] = concatArray(numberArrOne, numberArrTwo);
        print(result);

        result = nArrayConcat(numberArrOne, numberArrTwo, numberArrThree);
        print(result);
    }

    private static int[] nArrayConcat(int [] numberArrOne, int[]... others) {
        int totalLength = numberArrOne.length;
        for (int[] array : others) {
            totalLength += array.length;
        }
        int [] result = Arrays.copyOf(numberArrOne, totalLength);
        int offset = numberArrOne.length;
        for (int [] array : others) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }

    private static int[] concatArray(int[] numberArrOne, int[] numberArrTwo) {
        int []  result = Arrays.copyOf(numberArrOne, numberArrOne.length + numberArrTwo.length);
        System.arraycopy(numberArrTwo, 0, result, numberArrOne.length, numberArrTwo.length);
        return result;
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] +" - ");
        }
            System.out.println();
    }

}

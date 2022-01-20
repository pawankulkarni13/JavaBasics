package programs;

import java.util.Arrays;

public class MissingNumberInRangeDemo {

    public static void main(String[] args) {
        //Find the  one missing number in range
        //Input  :  arr[] = {13, 12, 11, 15}
        //Output :  14
        //
        //Input  :  arr[] = {33, 36, 35, 34};
        //Output : 37
        int arr[] = {13, 12, 11, 15};
        int result = findMissingNumber(arr);
        System.out.println(result);
        arr = new int[]{33, 36, 35, 34};
        result = findMissingNumber(arr);
        System.out.println(result);

    }

    private static int findMissingNumber(int[] arr) {
        Arrays.sort(arr);

        for(int i=0;i<arr.length-1;i++){

            if((arr[i+1]-arr[i])!=1)
                return arr[i]+1;

        }
        return arr[arr.length-1]+1;
    }
}

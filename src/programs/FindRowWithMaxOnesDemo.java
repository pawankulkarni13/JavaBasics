package programs;

import java.util.Arrays;

public class FindRowWithMaxOnesDemo {
    //Input matrix
    //0 1 1 1
    //0 0 1 1
    //1 1 1 1  // this row has maximum 1s
    //0 0 0 0
    //
    //Output: 2
    //Find the row with maximum number of 1s
    //Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } };
        System.out.println("Index of row with maximum 1s is "
                + rowWithMax1s(mat));
    }

    private static int rowWithMax1s(int[][] mat) {

        //Using Binary Search;
        int index=0;
        for(int i=0;i<mat.length;i++){
            System.out.println("i"+i+""+Arrays.binarySearch(mat[i],1));
            int idx = Arrays.binarySearch(mat[i],1);
            int value=0;

            if(idx==mat[i].length - 1)
                value = 1;
            if(idx>=0)
                value = (mat[i].length ) - idx;

            System.out.println(value);

            if(value>=index)
                index=value;
        }

        return index;


    }
}

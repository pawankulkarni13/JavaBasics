package arrays;

import java.util.Arrays;

public class RotateArrayAsImageDemo {

    public static void main(String[] args) {
        int [] [] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println(Arrays.deepToString((matrix)));
        rotate(matrix);
        System.out.println(Arrays.deepToString((matrix)));
    }

    private static void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i=0; i<n/2; i++)
            for (int j=i; j<n-i-1; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmp;
            }
    }
}

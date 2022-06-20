package programs;

import java.util.Arrays;

public class AddDigitsDemo {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(54321));
        System.out.println(repeatedProduct(54321));
        System.out.println(maxSumProduct(54321));
    }

    private static int addDigits(int num) {

        if (num == 0){
            return 0;
        }
        if (num % 9 == 0){
            return 9;
        }
        else {
            return num % 9;
        }
    }

    public static int repeatedProduct(int n) {
        int prod = 1;

        // Loop to do sum while
        // sum is not less than
        // or equal to 9
        while (n > 0 || prod > 9) {
            if (n == 0) {
                n = prod;
                prod = 1;
            }
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }

    // Function to find the maximum among
    // repeated sum and repeated product
    public static int maxSumProduct(int N) {

        if (N < 10)
            return N;

        return Math.max(addDigits(N), repeatedProduct(N));
    }

}

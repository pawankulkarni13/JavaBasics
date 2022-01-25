package programs;

public class FactorialDemo {
    public static void main(String[] args) {
        System.out.println(findFactorial(5));
        System.out.println(factorialRecursive(5));
    }

    private static int factorialRecursive(int n) {
        if (n <= 1)
            return 1;
        else
            return(n * factorialRecursive(n-1));
    }

    private static int findFactorial(int i) {
        int result = 1;
        for (int factor = 2; factor <= i; factor++) {
            result *= factor;
        }
        return result;
    }
}

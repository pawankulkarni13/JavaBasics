package programs;

public class FactorialDemo {
    public static void main(String[] args) {
        System.out.println(findFactorial(5));
    }

    private static int findFactorial(int i) {
        int result = 1;
        for (int factor = 2; factor <= i; factor++) {
            result *= factor;
        }
        return result;
    }
}

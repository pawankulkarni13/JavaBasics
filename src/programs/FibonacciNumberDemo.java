package programs;

public class FibonacciNumberDemo {
    public static void main(String[] args) {
        int n = 7;
        int result = fibonacci(n);
        System.out.println("fibonacci = " + result);
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

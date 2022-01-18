package programs;

public class PrimeNumberDemo {
    public static void main(String[] args) {
        System.out.println(isPrimeNumber(4));
        System.out.println(isPrimeNumber(3));
        System.out.println(isPrimeNumber(5));
    }

    private static boolean isPrimeNumber(int i) {
        if (i < 3) {
            return true;
        }

        if (i % 2 == 0) {
            return false;
        }

        for (int j = 3; j * i <= i; j += 2) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}

package programs;

/**
 * Given an integer N, the task is to print all proper fractions such that the denominator is less than or equal to N.
 * <p>
 * Proper Fractions: A fraction is said to be a proper fraction if the numerator is less than the denominator.
 * <p>
 * <p>
 * Examples:
 * <p>
 * Input: N = 3
 * Output: 1/2, 1/3, 2/3
 * <p>
 * Input: N = 4
 * Output: 1/2, 1/3, 1/4, 2/3, 3/4
 */
public class ProperFractionsDemo {

    public static void main(String[] args) {
        printProperFractions(3);
        printProperFractions(8);
    }

    private static void printProperFractions(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {

                if (hcf(i, j) == 1) {
                    System.out.print(i + "/" + j + ", ");
                }
            }
        }
        System.out.println();
    }

    private static int hcf(int i, int j) {
        return j == 0 ? i : hcf(j, i % j);
    }
}

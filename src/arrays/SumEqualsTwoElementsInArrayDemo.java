package arrays;

/**
 * Given an integer array and an integer value X, return two elements in that array such that sum of them equals to X.
 */
public class SumEqualsTwoElementsInArrayDemo {
    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};

        int [] nos = findNosEqualToSum(numbers, 91);
        System.out.println("Numbers are - ");
        System.out.println(nos[0]);
        System.out.println(nos[1]);

    }

    private static int[] findNosEqualToSum(int[] numbers, int i) {
        int[] result = new int[2];

        for (int j = 0; j < numbers.length-1; j++) {

            int k = j;

            while(k < numbers.length-1) {
                if (numbers[j] + numbers[k] == i) {

                    result [0] = numbers[j];
                    result [1] = numbers[k];
                }
                k++;
            }
        }
        return result;
    }
}

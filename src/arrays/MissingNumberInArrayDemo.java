package arrays;

/**
 * You are given an array of positive numbers from 1 to n, such that all numbers from 1 to n are present except one number x.
 * You have to find x.
 * The input array is not sorted.
 */
public class MissingNumberInArrayDemo {
    public static void main(String[] args) {
        int [] nums = {3,7,1,2,8,4,5};
        System.out.println("Missing Number is " + findMissingNumber(nums, 8));
    }

    private static int findMissingNumber(int[] nums, int n) {

        int expectedSum = 0;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }
        for(int i=0;i<=n;i++){
            expectedSum = expectedSum + i;
        }

        return expectedSum - actualSum;
    }
}

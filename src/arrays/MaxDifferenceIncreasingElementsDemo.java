package arrays;

/**
 * Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j]
 * (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
 * <p>
 * Return the maximum difference. If no such i and j exists, return -1.
 */
public class MaxDifferenceIncreasingElementsDemo {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 4};

        int result = maxDiff(nums);
        System.out.println(result);

    }

    private static int maxDiff(int[] nums) {
        int min = nums[0], r = -1;
        for (int ele : nums) {
            min = Math.min(min, ele);
            r = Math.max(r, ele - min);
        }
        if (r == 0)
            r = -1;
        return r;
    }
}

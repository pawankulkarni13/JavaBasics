package programs;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositiveDemo {

    public static void main(String[] args) {
        int [] nums = {7,8,9,11,12};
        System.out.println("First Missing Positive - "+Arrays.toString(nums)+"\t -->"+firstMissingPositive(nums));
        nums = new int[]{3, 4, -1, 1};
        System.out.println("First Missing Positive - "+Arrays.toString(nums)+"\t -->"+firstMissingPositive(nums));
        nums = new int[]{1, 2, 0};
        System.out.println("First Missing Positive - "+Arrays.toString(nums)+"\t -->"+firstMissingPositive(nums));
    }
    private static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            else if(nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i]-1);
            else i++;
        }
        i = 0;
        while(i < nums.length && nums[i] == i+1) i++;
        return i+1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

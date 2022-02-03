package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElementDemo {

    public static void main(String[] args) {

        int [] nums = {2,2,1,1,1,2,2};
        System.out.println(findMajorityElement(nums));
        nums = new int[]{3,2,3};
        System.out.println(findMajorityElementAlternate(nums));
    }

    private static int findMajorityElementAlternate(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
        }
        return major;
    }

    private static int findMajorityElement(int[] nums) {

        int len = nums.length/2;

        Map<Integer, Integer> map = new HashMap();
        for (int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        int majorityElement = 0;

        for(int key : map.keySet()){

            if(map.get(key) > len && key > majorityElement ){
                majorityElement = key;
            }
        }
        return majorityElement;
    }
}

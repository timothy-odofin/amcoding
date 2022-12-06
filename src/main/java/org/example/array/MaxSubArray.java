package org.example.array;
/**
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Thoughts:
 *
 * If for an array max, max[i] stands for the maximum subarray ending at position i.
 * * So that max[i] = Math.max(max[i-1], nums[i]). But all we need is the maximum subarray
 * * for the whole array. So that we even don’t need the
 * * actual array. Just use a temp variable to keep the previous max value.*
 * * * */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            currSum = Math.max(currSum + num, num);
            max = Math.max(currSum, max);
        }
        return max;
    }
    public int maxSubArray2(int[] nums) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if(currSum<0){
                currSum=0;
            }
            currSum +=num;
            max = Math.max(currSum, max);
        }
        return max;
    }
}

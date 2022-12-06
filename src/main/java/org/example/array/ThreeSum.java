package org.example.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Thoughts:
 *
 * Key idea here is to sort the array first. Then start from left to pick the first element to be a,
 * * then find if there are two other elements b, c make a + b + c = 0.
 * * Another thing to keep in mind is that how to avoid duplicate answers.* *
 * * * */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == 0){
                        List<Integer> tmp = new LinkedList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        result.add(tmp);
                        int startVal = nums[start];
                        int endVal = nums[end];
                        while (start < end && startVal == nums[start]) {
                            start ++;
                        }
                        while (end > start && endVal == nums[end]) {
                            end --;
                        }
                    }
                    else if (sum < 0) {
                        start ++;
                    }
                    else {
                        end --;
                    }
                }
            }
        }
        return result;
    }
}

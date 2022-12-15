package org.example.array;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * Medium
 * 9.5K
 * 156
 * Companies
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * * * */
public class PartisionEqualsSubsetForm {
    public boolean canPartition(int[] nums) {
        ///Arrays.sort(nums); not neccessary
        int sum = 0;
        for(int i =0;i<nums.length;i++)
        {
            sum += nums[i];
        }
        if(sum%2!= 0)
            return false;
        sum = sum/2;

        for(int i = nums.length-1;i>0;i--)
        {
            int tmp = nums[i];
            if(tmp>sum)
                return false;
            if(tmp == sum)
                return true;
            int index = i-1;
            while(index>=0)
            {
                tmp+=nums[index];
                if(tmp>sum)
                    tmp=tmp-nums[index];
                if(tmp<sum)
                    index--;
                else
                    return true;
            }
        }
        return false;
    }

}

/**
 * The idea is pretty simple.
 * sort the array first
 * sum all the element, if the sum is not an even number, return false
 * Starts from the end,
 * tmp is to record the temp sum of chosen elements
 * if tmp == sum/2 return true
 * if tmp > sum/2 deduct the recently added element, move the index to the left, since the element in the left position is smaller.
 * * * **/

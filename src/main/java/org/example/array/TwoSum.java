package org.example.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int key = target-nums[i];
            if(map.containsKey(key)){
                return new int[]{map.get(key),i};
            }else{
                map.put(nums[i],i); // put the index and number intomap
            }
        }
        return new int[]{-1,-1}; // no record found;
    }



}

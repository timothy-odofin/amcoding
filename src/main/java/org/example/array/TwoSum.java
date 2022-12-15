package org.example.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

    public static int countPairs(List<Integer> numbers, int k) {
        int l = 0, r = 0, ans = 0, n;
        n = numbers.size();
        Collections.sort(numbers);
        while (r < n) {
            if (numbers.get(r) - numbers.get(l) == k) {
                ans++;
                r++;
// since we have to count distinct pairs so
// we have to make (a,b) either a or b different from previous pair.
                while (r < n && numbers.get(r - 1) == numbers.get(r))
                    r++;
                l++;
            } else if (numbers.get(r) - numbers.get(l) < k)
                r++;
            else
                l++;
        }
        return ans;
    }

}

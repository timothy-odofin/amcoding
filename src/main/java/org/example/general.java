package org.example;

public class general {
    /**
     * 70 Climbing Stairs – Easy
     * Problem:
     *
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * Thoughts:
     *
     * Very straight forward solution.
     *
     * ways[i] = ways[i-1] + ways[i-2];
     * * * */
    public int climbStairs(int n) {
        int prepre = 0, pre = 1;
        for (int i = 0; i < n; i ++) {
            int tmp = prepre + pre;
            prepre = pre;
            pre = tmp;
        }
        return pre;
    }//climb

    /**
     * 169 Majority Element – Easy
     * Problem:
     *
     * Given an array of size n, find the majority element. The majority element is the element that appears more
     * * than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * Thoughts:
     *
     * Use a counter for currently met element. Since the major element will eventually win no matter where it starts.
     * *
     * Complexity Analysis
     *
     *     Time complexity : O(nlog⁡C)O(nlogC)
     *
     *     CC is the max absolute value in nums, i.e., 105105 in this problem. We enumerate all log⁡ClogC bits for each number in nums.
     *
     *     Space complexity: O(1)O(1)
     *
     *     We count the majority of each bit in O(1)O(1) space as it only has the two potential values, 0 and 1.
     *     *     After that, we only need to put the majority
     *     *     values to their corresponding bit in the returned result, and no extra space is used.
     * * * * */
    public int majorityElement(int[] num) {
        int candidate = num[0];
        int counter = 1;
        for (int i = 1; i < num.length; i ++){
            if (counter == 0){
                candidate = num[i];
                counter = 1;
            }
            else{
                if (num[i] == candidate)
                    counter ++;
                else
                    counter --;
            }
        }//for i
        return candidate;
    }
/**
 * 67 Add Binary – Easy
 * Problem:
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example, a = "11" b = "1" Return "100".
 * Thoughts:
 *
 * Very straight forward solution.
 * Solutions:
 *
 * Improve logic. This is a version of solution that is more into clean code.
 * * If looking for a more efficient way, need to avoid unnecessary calculation, e.g.
 * * when you have a lot of 0 in the end for both number, you don’t want to keep calculate 0 + 0 + 0.
 * * * */
    public String addBinary(String a, String b) {
        String result = "";
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >=0 && j >=0 && a.charAt(i) == '0' && b.charAt(j) == '0') {
            result = '0' + result;
            i --;
            j --;
        }
        while (i >=0 || j >=0) {
            int tmp = (i >=0?(a.charAt(i)- '0'):0 ) + (j >=0?(b.charAt(j) - '0'):0) + carry;
            carry = tmp / 2;
            int digit = tmp % 2;
            result = digit + result;
            i --;
            j --;
        }
        if (carry > 0) {
            result = carry + result;
        }
        return result;
    }
}

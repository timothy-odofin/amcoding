package org.example.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * * *
 **/
public class LongestSubStringWithoutRepeatingChar {


    /**
     * Complexity Analysis
     * Time complexity : O(n)O(n). Index jj will iterate nn times.
     * <p>
     * Space complexity : O(min(m, n))O(min(m,n)). Same as the previous approach.
     * * *
     */

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        for (int right = 0, left = 0; right < n; right++) {
            int indexOfFirstAppearanceInSubString = s.indexOf(s.charAt(right), left);
            if (indexOfFirstAppearanceInSubString != right) {
                left = indexOfFirstAppearanceInSubString + 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    private boolean isBadVersion(int n) {
        return true;

    }

    public int getBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

package org.example.string;

import java.util.HashSet;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * * removing all non-alphanumeric characters,
 * * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * * * */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        boolean result = true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                i ++;
                continue;
            }
            if (!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                j --;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                result = false;
                break;
            }
            i ++;
            j --;
        }
        return result;
    }

    /**
     * 5 Longest Palindromic Substring
     * Problem:
     *
     * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
     * * and there exists one unique longest palindromic substring.
     * Thoughts:
     *
     * Trivial way is to calculate each substring is palindrome, using O(n^2) time and space.
     * * Could be optimized using only O(1) space.
     * * Idea is to return the longest palindromic substring that is center by (i,i) or (i, i + 1).
     * * * */
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i ++){
            String tmp = "";
            tmp = paCenterBy(s, i, i);
            if (tmp.length() > longest.length()){
                longest = tmp;
            }
            tmp = paCenterBy(s, i, i + 1);
            if (tmp.length() > longest.length()){
                longest = tmp;
            }
        }
        return longest;
    }
    private String paCenterBy(String s, int cleft, int cright){
        String result = "";
        while (cleft >=0 && cright < s.length() && s.charAt(cleft) == s.charAt(cright)){
            cleft --;
            cright ++;
        }
        return s.substring(cleft + 1, cright);
    }

    /**
     * 409. Longest Palindrome
     * Problem:
     *
     * Given a string which consists of lowercase or uppercase letters,
     * * find the length of the longest palindromes that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note: Assume the length of given string will not exceed 1,010.
     * Complexity Analysis
     *
     *     Time Complexity: O(N)O(N), where NN is the length of s. We need to count each letter.
     *
     *     Space Complexity: O(1)O(1), the space for our count, as the alphabet size of s is fixed.
     *     *     We should also consider that in a bit complexity model,
     *     *     technically we need O(log⁡N)O(logN) bits to store the count values.*
     * * * */
    public int longestPalindromeV2(String s) {
        int count = 0;
        HashSet<Character> data = new HashSet<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (data.contains(c)) {
                count += 2;
                data.remove(c);
            }
            else {
                data.add(c);
            }
        }
        if (data.size() > 0) {
            count ++;
        }
        return count;
    }
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
}

package org.example.string;

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

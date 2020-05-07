package org.hryciuk.stayinshape.strings;

/**
 * 5. Longest Palindromic Substring
 * Medium
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {





    public String bruteForceLongestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        if (s.length() == 1) {
            return s;
        }
        int[][] lengthsOfPalindromes = new int[s.length()][s.length()];
        int maxLengthOfPalindrome = 0;
        int startOfLongestPalindrome = 0;
        int endOfLongestPalindrome = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                String substring = s.substring(i, j + 1);
                boolean isItAPalindrome = isPalindrome(substring);
                if (isItAPalindrome && lengthsOfPalindromes[i][j] == 0) {
                    int lengthOfAPalindrome = substring.length();
                    if (lengthOfAPalindrome > maxLengthOfPalindrome) {
                        maxLengthOfPalindrome = lengthOfAPalindrome;
                        startOfLongestPalindrome = i;
                        endOfLongestPalindrome = j;
                    }
                    lengthsOfPalindromes[i][j] = lengthOfAPalindrome;
                }
            }
        }
        return s.substring(startOfLongestPalindrome, endOfLongestPalindrome + 1);
    }

    private boolean isPalindrome(String substringToCheck) {
        if (substringToCheck == null || substringToCheck.isEmpty()) {
            return true;
        }
        if (substringToCheck.length() == 1) {
            return true;
        }
        char[] chars = substringToCheck.toCharArray();
        for (int i = 0; i < chars.length / 2; ++i) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}

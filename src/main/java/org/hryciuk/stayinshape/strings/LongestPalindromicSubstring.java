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

    // Time: O(n^2), Space O(1)
    public String expandFromTheMiddle(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); ++i) {
            int firstCaseLength = checkLongestPalindromeFromMiddle(s, i, i + 1); //ab|ba
            int secondCaseLength = checkLongestPalindromeFromMiddle(s, i, i); //rac|e|car
            int max = Math.max(firstCaseLength, secondCaseLength);
            if (max > end - start) {
                start = i - ((max - 1) / 2);
                end = i + (max / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    // Time: O(n^2), Space O(n^2)
    public String longestPalindromicSubstringDynamicProgramming(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int longestPalindromicSubstringStart = 0;
        int longestPalindromicSubstringEnd = 0;
        int stringLength = s.length();
        boolean[][] isPalindrome = new boolean[stringLength][stringLength];
        // setting up diagonal of an array; length == 1
        for (int i = 0; i < s.length(); ++i) {
            isPalindrome[i][i] = true;
        }
        // length == 2
        for (int i = 0; i + 1 < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                longestPalindromicSubstringStart = i;
                longestPalindromicSubstringEnd = i + 1;
            }
        }
        // length >= 3
        for (int j = 2; j < s.length(); ++j) {
            for (int i = 0; i < s.length() - j; ++i) {
                if ((s.charAt(i) == s.charAt(j + i)) && isPalindrome[i + 1][j + i - 1]) {
                    isPalindrome[i][j + i] = true;
                    longestPalindromicSubstringStart = i;
                    longestPalindromicSubstringEnd = j + i;
                }
            }
        }
        return s.substring(longestPalindromicSubstringStart, longestPalindromicSubstringEnd + 1);
    }

    private int checkLongestPalindromeFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }
        while (left <= right && left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    // O(n^3)
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

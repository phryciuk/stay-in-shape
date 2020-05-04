package org.hryciuk.stayinshape.strings;

/**
 * 132. Palindrome Partitioning II
 * Hard
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning2 {

    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] minimumCuts = new int[s.length()];
        minimumCuts[0] = 0;
//        for (int i = 1; i < chars.length; ++i) {
//
//        }
        return 1;
    }

    private boolean isPalindrome(String toTest) {
        if (toTest == null || toTest.isEmpty()) {
            return false;
        }
        if (toTest.length() == 1) {
            return true;
        }
        char[] chars = toTest.toCharArray();
        for (int i = 0; i < chars.length / 2; ++i) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}

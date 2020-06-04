package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 132. Palindrome Partitioning II
 * Hard
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning2 {

    // Time: O(n^3); Space: O(n^2)
    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // initializing the array of whether a substring is palindromic
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                isPalindrome[i][j] = isPalindrome(s.substring(i, j + 1));
            }
        }
        // initialize the array that will hold the number of cuts
        int[] cuts = new int[s.length()];
        for (int i = 0; i < cuts.length; ++i) {
            cuts[i] = i;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (isPalindrome[0][i]) {
                cuts[i] = 0;
            } else {
                for (int j = 0; j <= i; ++j) {
                    if (isPalindrome[j][i]) {
                        cuts[i] = Math.min(cuts[j - 1] + 1, cuts[i]);
                    }
                }
            }
        }
        return cuts[s.length() - 1];
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

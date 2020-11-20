package org.hryciuk.stayinshape.strings;

import java.util.Arrays;

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

    // Time: O(n^2); Space: O(n^2)
    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // initializing the array of whether a substring is palindromic
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        // we can observe a thing about a palindrome:
        // palindrome is a palindrome only when first and last character match && inner characters form a palindrome

        // strings with length of 1; all single characters are in fact palindromes.
        for (int i = 0; i < n; ++i) {
            isPalindrome[i][i] = true;
        }

        // strings with length of 2 are palindromic if edge letters (so in fact only letters) are same
        for (int i = 0; i < n - 1; ++i) {
            int j = i + 1;
            if (s.charAt(i) == s.charAt(j)) {
                isPalindrome[i][j] = true;
            }
        }

        // for string with length >= 3
        // palindrome is a palindrome only when first and last character match && inner characters form a palindrome
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from starting index i and length k
                int j = i + k - 1;
                // checking for sub-string from ith index to jth index if str.charAt(i+1) to str.charAt(j-1) is a palindrome
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        // we initialize the cuts array; this will store the minimum cuts; index i means minimum cuts in a substring[0...i];
        int[] cuts = new int[n];
        for (int i = 0; i < n; ++i) {
            cuts[i] = Integer.MAX_VALUE;
        }

        for (int j = 0; j < n; ++j) {
            if (isPalindrome[0][j]) {
                cuts[j] = 0;
            } else {
                for (int i = 0; i <= j; ++i) {
                    if (isPalindrome[i][j]) {
                        cuts[j] = Math.min(cuts[i - 1] + 1, cuts[j]);
                    }
                }
            }
        }
        return cuts[n - 1];
    }

    public int minCut2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        // strings of length 1
        for (int i = 0; i < s.length(); ++i) {
            isPalindrome[i][i] = true;
        }

        // 2 characters
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                isPalindrome[i - 1][i] = true;
            }
        }

        // 3 characters and longer
        for (int j = 2; j < s.length(); ++j) {
            for (int i = 0; i < j - 1; ++i) {
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        int[] minCuts = new int[s.length()];
        Arrays.fill(minCuts, Integer.MAX_VALUE);


        for (int j = 0; j < s.length(); ++j) {
            if (isPalindrome[0][j]) {
                minCuts[j] = 0;
            } else {
                for (int i = 0; i <= j; ++i) {
                    if (isPalindrome[i][j]) {
                        minCuts[j] = Math.min(minCuts[i - 1] + 1, minCuts[j]);
                    }
                }
            }
        }
        return minCuts[s.length() - 1];
    }


}

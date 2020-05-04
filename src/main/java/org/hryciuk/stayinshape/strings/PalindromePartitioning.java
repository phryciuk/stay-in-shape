package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Medium
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<List<String>> result = new ArrayList<>();
        if (s.length() == 1) {
            List<String> singlePartition = Arrays.asList(s);
            result.add(singlePartition);
            return result;
        }
        return result;
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

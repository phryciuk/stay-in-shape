package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    private Map<String, Integer> minimumNumberOfCuts = new HashMap<>();

    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        decompose(s, 0, new ArrayList<>());
        return 1;
    }

    private void decompose(String s, int index, ArrayList<String> temp) {
        if (index == s.length()) {
            temp.forEach(val -> minimumNumberOfCuts.put(val, 0));
        }
        for (int i = index; i < s.length(); ++i) {
            String substring = s.substring(index, i);
            if (isPalindrome(substring)) {
                temp.add(substring);
                decompose(s, index + 1, temp);
                temp.remove(temp.size() - 1);
            } else {
//                char[] charArray = substring.toCharArray();
                for (int j = 0; j < substring.length(); ++j) {
                    String substringOfASubstring = substring.substring(0, j);
                    minimumNumberOfCuts.putIfAbsent(substringOfASubstring, 1);
                }
            }
        }
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

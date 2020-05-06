package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Medium
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<>(), 0, s);
        return result;
    }

    private void partition(List<List<String>> result, List<String> tempList, int position, String s) {
        if (s.length() == position) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i = position; i < s.length(); ++i) {
            if (isPalindrome(s, position, i+1)) {
                tempList.add(s.substring(position, i+1));
                partition(result, tempList, i+1, s);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String toTest, int beginning, int ending) {
        if (toTest == null || toTest.isEmpty()) {
            return false;
        }
        if (toTest.length() == 1) {
            return true;
        }
        String substring = toTest.substring(beginning, ending);
        char[] chars = substring.toCharArray();
        for (int i = 0; i < chars.length / 2; ++i) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}

package org.hryciuk.stayinshape.strings;

/**
 * 680. Valid Palindrome II
 * Easy
 * <p>
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "aba"
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * <p>
 * Note:
 * <p>
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int length = s.length();
        int[] charOccurrences = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            charOccurrences[currentChar - 'a']++;
        }
        int oddOccurrences = 0;
        for (int i = 0; i < charOccurrences.length; ++i) {
            if (charOccurrences[i] % 2 == 1) {
                oddOccurrences++;
            }
        }
        if (length % 2 == 0) {
            if (oddOccurrences == 2 || oddOccurrences == 0) {
                if (charOccurrences[s.charAt(0) - 'a'] == 1 && charOccurrences[s.charAt(s.length() - 1) - 'a'] == 1) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            if (oddOccurrences == 1 || oddOccurrences == 0) {
                return true;
            }
        }
        return false;
    }
}

package org.hryciuk.stayinshape.strings;

/**
 * 387. First Unique Character in a String
 * Easy
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 *
 *
 * Note: You may assume the string contains only lowercase English letters.
 */
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        char[] string = s.toCharArray();
        int[] occurrences = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            occurrences[string[i] - 'a']++;
        }

        for (int i = 0; i < string.length; ++i) {
            if (occurrences[string[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

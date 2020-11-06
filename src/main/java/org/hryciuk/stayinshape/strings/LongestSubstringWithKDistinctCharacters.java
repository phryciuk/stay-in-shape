package org.hryciuk.stayinshape.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement #
 * <p>
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * <p>
 * Example 2:
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * <p>
 * Example 3:
 * <p>
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringWithKDistinctCharacters {

    public int findLength(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        Map<Character, Integer> occurrences = new HashMap<>();
        int longestSubstring = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            char current = arr[i];
            occurrences.put(current, occurrences.getOrDefault(current, 0) + 1);
            while (occurrences.size() > k) {
                char atStart = arr[start];
                occurrences.put(atStart, occurrences.get(atStart) - 1);
                if (occurrences.get(atStart) == 0) {
                    occurrences.remove(atStart);
                }
                start++;
            }
            longestSubstring = Math.max(longestSubstring, i - start + 1);
        }
        return longestSubstring;
    }

}

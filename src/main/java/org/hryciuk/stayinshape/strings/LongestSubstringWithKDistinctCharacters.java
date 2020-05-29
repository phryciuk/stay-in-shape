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

    public int findLength(String str, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int longestSubstringLength = Integer.MIN_VALUE;
        char[] stringAsChars = str.toCharArray();
        int startOfWindow = 0;
        int endOfWindow = 0;
        for (int i = 0; i < stringAsChars.length; ++i) {
            char currentCharacter = stringAsChars[i];
            charFrequencyMap.put(currentCharacter, charFrequencyMap.getOrDefault(currentCharacter, 0) + 1);
            while (charFrequencyMap.size() > k) {
                char startOfWindowChar = stringAsChars[startOfWindow];
                charFrequencyMap.put(startOfWindowChar, charFrequencyMap.get(startOfWindowChar) - 1);
                if (charFrequencyMap.get(startOfWindowChar) == 0) {
                    charFrequencyMap.remove(startOfWindowChar);
                }
                startOfWindow++;
            }
            endOfWindow++;
            longestSubstringLength = Math.max(longestSubstringLength, endOfWindow - startOfWindow);
        }
        return longestSubstringLength;
    }

}

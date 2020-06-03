package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * Medium
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInString {

    // Time: O(s.length() * 26); Space: O(26)
    public List<Integer> findAnagrams(String s, String p) {
        int[] occurrences = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            occurrences[p.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int startOfWindow = 0;
        for (int endOfWindow = 0; endOfWindow < s.length(); ++endOfWindow) {
            char current = s.charAt(endOfWindow);
            occurrences[current - 'a']--;
            if (endOfWindow - startOfWindow + 1 > p.length()) {
                occurrences[s.charAt(startOfWindow) - 'a']++;
                startOfWindow++;
            }
            if (allOccurrencesUsed(occurrences)) {
                result.add(startOfWindow);
            }
        }
        return result;
    }

    private boolean allOccurrencesUsed(int[] occurrences) {
        for (int i = 0; i < occurrences.length; ++i) {
            if (occurrences[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

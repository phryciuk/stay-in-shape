package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 *
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 *
 * Input:
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * Output: []
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        int lengthOfSingleWord = -1;
        if (words.length != 0) {
            lengthOfSingleWord = words[0].length();
        }
        s = s.toLowerCase();
        int[] charOccurrences = new int[256];
        int[] wordOccurrences = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            words[i] = words[i].toLowerCase();
            for (int j = 0; j < lengthOfSingleWord; ++j) {
                charOccurrences[words[i].charAt(j) - 'a']++;
            }
            wordOccurrences[i] = 1;
        }
        int startOfWindow = 0;
        List<Integer> result = new ArrayList<>();
        for (int endOfWindow = 0; endOfWindow < s.length(); ++endOfWindow) {
            charOccurrences[s.charAt(endOfWindow) - 'a']++;
            if (endOfWindow - startOfWindow + 1 > lengthOfSingleWord) {
                String substring = s.substring(startOfWindow, endOfWindow);
                for (int i = 0; i < words.length; ++i) {
                    if (words[i].equals(substring) && wordOccurrences[i] > 0) {
                        wordOccurrences[0]--;
//                        if ()
                    }
                }
            }
        }
        return null;
    }
}

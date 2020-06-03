package org.hryciuk.stayinshape.strings;

/**
 * 76. Minimum Window Substring
 * Hard
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * Note:
 *
 *     If there is no such window in S that covers all characters in T, return the empty string "".
 *     If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    // Time: s.length + (s.length - t.length + 1) * 256
    // Space: O(256)
    public String minWindow(String s, String t) {
        int[] occurrences = new int[256];
        for (int i = 0; i < t.length(); i++) {
            occurrences[t.charAt(i)]++;
        }

        int startOfWindow = 0;
        String minimumWindowSubstring = "";
        for (int endOfWindow = 0; endOfWindow < s.length(); ++endOfWindow) {
            char current = s.charAt(endOfWindow);
            occurrences[current]--;
            if (endOfWindow - startOfWindow + 1 >= t.length()) {
                while (areAllCharactersUsed(occurrences, t)) {
                    if ((endOfWindow - startOfWindow + 1 < minimumWindowSubstring.length()) || minimumWindowSubstring.equals("")) {
                        minimumWindowSubstring = s.substring(startOfWindow, endOfWindow + 1);
                    }
                    occurrences[s.charAt(startOfWindow)]++;
                    startOfWindow++;
                }
            }
        }
        return minimumWindowSubstring;
    }

    private boolean areAllCharactersUsed(int[] occurrences, String t) {
        for (int i = 0; i < occurrences.length; ++i) {
            if (occurrences[i] > 0) {
                return false;
            }
        }
        return true;
    }

}

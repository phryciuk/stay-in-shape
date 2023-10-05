package org.hryciuk.stayinshape.strings;

import java.util.HashMap;
import java.util.Map;

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

    public String minWindow2(String s, String t) {
        // count characters of T
        Map<Character, Integer> tMap = new HashMap<>();
        char[] arrT = t.toCharArray();
        for (int i = 0; i < arrT.length; ++i) {
            tMap.put(arrT[i], tMap.getOrDefault(arrT[i], 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        char[] arrS = s.toCharArray();

        int min = Integer.MAX_VALUE;
        String result = "";
        int need = tMap.size();
        int have = 0;
        int l = 0;
        for (int r = 0; r < arrS.length; ++r) {
            char current = arrS[r];
            sMap.put(current, sMap.getOrDefault(current, 0) + 1);
            if (tMap.containsKey(current) && tMap.get(current).equals(sMap.get(current))) {
                have++;
            }
            while (have == need) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    result = s.substring(l, r + 1);
                }
                sMap.put(arrS[l], sMap.getOrDefault(arrS[l], 0) - 1);
                if (tMap.containsKey(arrS[l]) && tMap.get(arrS[l]) > sMap.get(arrS[l])) {
                    have--;
                }
                l++;
            }
        }
        return result;
    }



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

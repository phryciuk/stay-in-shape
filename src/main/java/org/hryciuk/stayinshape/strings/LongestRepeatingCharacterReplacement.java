package org.hryciuk.stayinshape.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int l = 0;
        Map<Character, Integer> occurrences = new HashMap<>();
        int maxCharFrequency = 0;
        char[] arr = s.toCharArray();
        int maxLength = 0;
        for (int r = 0; r < arr.length; ++r) {
            occurrences.put(arr[r], occurrences.getOrDefault(arr[r], 0) + 1);
            maxCharFrequency = Math.max(maxCharFrequency, occurrences.get(arr[r]));
            if (r - l + 1 - maxCharFrequency > k) {
                occurrences.put(arr[l], occurrences.getOrDefault(arr[l], 0) - 1);
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}

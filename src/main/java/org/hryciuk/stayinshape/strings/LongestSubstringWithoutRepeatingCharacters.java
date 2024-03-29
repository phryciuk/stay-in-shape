package org.hryciuk.stayinshape.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int l = 0;
        for (int r = 0; r < s.length(); ++r) {
            char current = s.charAt(r);
            while (set.contains(current)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(current);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int startOfWindow = 0;
        int maxLengthOfSubstringWithoutRepeatingCharacters = 0;
        Map<Character, Integer> characterToIndexOfLastOccurrence = new HashMap<>();
        for (int endOfWindow = 0; endOfWindow < s.length(); ++endOfWindow) {
            char currentChar = s.charAt(endOfWindow);
            if (characterToIndexOfLastOccurrence.containsKey(currentChar)) {
                // startOfWindow is indeed the last occurrence of the same char + 1
                // say, for string "abbac",
                // when
                // - `currentPos` == 0, theChar == "a", charRecorderMap.containsKey(theChar) == false, `startOfWindow` == 0;
                // - `currentPos` == 1, theChar == "b", charRecorderMap.containsKey(theChar) == false, `startOfWindow` == 0;
                // - `currentPos` == 2, theChar == "b", charRecorderMap.containsKey(theChar) == true,  `startOfWindow` == 2;
                //    charRecorderMap.get(theChar) == 1;
                // that means, if we found any char (say, "b") is duplicated,
                // we should reset the substring start position to the position right after the duplicated char (+1)

                // - `currentPos` == 3, theChar == "a", charRecorderMap.containsKey(theChar) == true,  `startOfWindow` == 2;
                //    charRecorderMap.get(theChar) == 0;
                //    charRecorderMap.get(theChar) + 1 < startOfWindow // charRecorderMap.get(theChar)  is actually the first "a", which is at pos 0;

                // That is to say, we should always set `newSubstringStartPos` to the rightmost position of any duplicated chars
                startOfWindow = Math.max(startOfWindow, characterToIndexOfLastOccurrence.get(currentChar) + 1);
            }
            characterToIndexOfLastOccurrence.put(currentChar, endOfWindow);
            maxLengthOfSubstringWithoutRepeatingCharacters = Math.max(maxLengthOfSubstringWithoutRepeatingCharacters, endOfWindow - startOfWindow + 1);
        }
        return maxLengthOfSubstringWithoutRepeatingCharacters;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int start = 0;
        int longest = 0;
        Map<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            char current = arr[i];
            if (charToIndex.containsKey(current)) {
                int index = charToIndex.get(current);
                start = Math.max(start, index + 1);
            }
            charToIndex.put(current, i);
            longest = Math.max(longest, i - start + 1);
        }
        return longest;
    }
}

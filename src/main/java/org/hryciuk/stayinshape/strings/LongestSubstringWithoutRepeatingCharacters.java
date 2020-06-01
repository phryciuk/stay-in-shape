package org.hryciuk.stayinshape.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
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
}

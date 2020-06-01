package org.hryciuk.stayinshape.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int startOfWindow = 0;
        int lengthOfMaxRepeatingCharacter = 0;
        int maxLength = 0;
        Map<Character, Integer> charOccurrences = new HashMap<>();
        for (int endOfWindow = 0; endOfWindow < s.length(); ++endOfWindow) {
            char rightChar = s.charAt(endOfWindow);
            charOccurrences.put(rightChar, charOccurrences.getOrDefault(rightChar, 0) + 1);
            lengthOfMaxRepeatingCharacter = Math.max(lengthOfMaxRepeatingCharacter, charOccurrences.get(rightChar));
            if (endOfWindow - startOfWindow - lengthOfMaxRepeatingCharacter + 1 > k) {
                char leftChar = s.charAt(startOfWindow);
                charOccurrences.put(leftChar, charOccurrences.get(leftChar) - 1);
                startOfWindow++;
            }
            maxLength = Math.max(maxLength, endOfWindow - startOfWindow + 1);
        }
        return maxLength;
    }
}

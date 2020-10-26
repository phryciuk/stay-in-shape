package org.hryciuk.stayinshape.strings;

import java.util.*;

public class SherlockAndTheValidString {
    boolean sameNumberOfOccurrencesOfEveryCharacter(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] arr = s.toCharArray();
        int[] occurrences = new int[128];

        for (int i = 0; i < arr.length; ++i) {
            char c = arr[i];
            occurrences[c]++;
        }

        int number = -1;
        for (int i = 0; i < occurrences.length; ++i) {
            if (occurrences[i] != 0) {
                if (number == -1) {
                    number = occurrences[i];
                } else {
                    if (occurrences[i] != number) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean sameNumberOfOccurrencesOfEveryCharacterOrOffByOne(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] arr = s.toCharArray();
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            char c = arr[i];
            occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> numberOfLettersToFrequency = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            numberOfLettersToFrequency.put(entry.getValue(), numberOfLettersToFrequency.getOrDefault(entry.getValue(), 0) + 1);
        }
        // all values have same frequency
        if (numberOfLettersToFrequency.size() == 1) {
            return true;
        }
        // more than 2 frequencies
        if (numberOfLettersToFrequency.size() > 2) {
            return false;
        }
        // exactly two values;
        // one occurrence of single character
        if (numberOfLettersToFrequency.containsKey(1) && numberOfLettersToFrequency.get(1) == 1) {
            return true;
        } else {
            // difference between the number of letters is 1
            // and part with more characters occurs only 1, e.g. aaaabbbccc
            Integer minKey = Collections.min(numberOfLettersToFrequency.keySet());
            Integer maxKey = Collections.max(numberOfLettersToFrequency.keySet());
            if (maxKey - minKey == 1 && numberOfLettersToFrequency.get(maxKey) == 1) {
                return true;
            }
        }
        return false;
    }

}

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

        Map<Integer, Integer> valueToFrequency = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            valueToFrequency.put(entry.getValue(), valueToFrequency.getOrDefault(entry.getValue(), 0) + 1);
        }
        if (valueToFrequency.size() == 1) {
            return true;
        }
        if (valueToFrequency.size() > 2) {
            return false;
        }
        // exactly two values;
        if (valueToFrequency.containsKey(1) && valueToFrequency.get(1) == 1) {
            return true;
        } else {
            Integer minKey = Collections.min(valueToFrequency.keySet());
            Integer maxKey = Collections.max(valueToFrequency.keySet());
            if (maxKey - minKey == 1 && valueToFrequency.get(maxKey) == 1) {
                return true;
            }
        }
        return false;

    }
}

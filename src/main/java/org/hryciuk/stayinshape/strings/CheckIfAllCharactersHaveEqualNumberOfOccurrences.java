package org.hryciuk.stayinshape.strings;

import java.util.HashMap;
import java.util.Map;

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {

    /*
        1st solution. Naive in terms of memory.
        Iterate over the string and add every character to hashmap.
        Then get the occurrence of 1st character, and iterate over the map values.
        Every value should be the same. If not - then occurrences are not equal.
     */
    public boolean areOccurrencesEqual(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            char current = arr[i];
            occurrences.put(current, occurrences.getOrDefault(current, 0) + 1);
        }
        if (occurrences.keySet().size() == 1) {
            return true;
        }
        int numberOfOccurrences = occurrences.get(s.charAt(0));
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() != numberOfOccurrences) {
                return false;
            }
        }
        return true;
    }

    /*
     This version is improved in terms of memory. Instead of creating a hashmap, we can create a simple array.
     This is based on the condition that we know what is the charset we are using.
     In this task it is specified that "s consists of lowercase English letters." so there is at max 26 elements.
     */
    public boolean areOccurrencesEqual2(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        char[] arr = s.toCharArray();
        int[] occurrences = new int[26];
        for (int i = 0; i < arr.length; ++i) {
            char current = arr[i];
            occurrences[current - 'a']++; // we use the fact that in ASCII charset, lowercase letters go after each other
            // 'a' has a 97 index in the ASCII character table
            // this trick relativizes the letters, so that a: 0 (97-97), b: 1, c: 2 etc.
        }
        int occurrency = -1;
        for (int i = 0; i < occurrences.length; ++i) {
            int current = occurrences[i];
            if (current == 0) {
                continue;
            }
            if (occurrency == -1) {
                occurrency = current;
            }
            if (current != occurrency) {
                return false;
            }
        }
        return true;
    }
}

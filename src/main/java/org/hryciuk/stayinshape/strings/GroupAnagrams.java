package org.hryciuk.stayinshape.strings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return results;
        }
        Map<String, List<String>> mapOfStrings = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            String currentOne = strs[i];
            int[] arrayOfOccurrences = getArrayOfOccurrences(currentOne);
            String asString = Arrays.toString(arrayOfOccurrences);
            if (mapOfStrings.containsKey(asString)) {
                mapOfStrings.get(asString).add(currentOne);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(currentOne);
                mapOfStrings.put(asString, newList);
            }
        }
        for (Map.Entry<String, List<String>> entry : mapOfStrings.entrySet()) {
            results.add(entry.getValue());
        }
        return results;
    }

    int[] getArrayOfOccurrences(String str) {
        char[] chars = str.toCharArray();
        int[] occurrences = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            char currentChar = chars[i];
            occurrences[currentChar - 'a']++;
        }
        return occurrences;
    }
}

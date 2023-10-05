package org.hryciuk.stayinshape.strings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToGroup = new HashMap<>();
        for (String current : strs) {
            char[] arrayOfOccurrences = getArrayOfOccurrences(current);
            String createdKey = Arrays.toString(arrayOfOccurrences);
            if (!keyToGroup.containsKey(createdKey)) {
                keyToGroup.put(createdKey, new ArrayList<>());
            }
            keyToGroup.get(createdKey).add(current);
        }
        return new ArrayList<>(keyToGroup.values());
    }

    char[] getArrayOfOccurrences(String str) {
        char[] arr = str.toCharArray();
        char[] occurrences = new char[26];
        for (int i = 0; i < str.length(); ++i) {
            char currentChar = arr[i];
            occurrences[currentChar - 'a']++;
        }
        return occurrences;
    }
}

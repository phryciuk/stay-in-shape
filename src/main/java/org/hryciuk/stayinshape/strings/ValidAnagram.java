package org.hryciuk.stayinshape.strings;

public class ValidAnagram {

    // Time complexity: O(n), Space complexity: O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        int[] occurrences = new int[26];

        for (int i = 0; i < first.length; ++i) {
            occurrences[first[i] - 'a']++;
        }

        for (int i = 0; i < second.length; ++i) {
            occurrences[second[i] - 'a']--;
        }

        for (int i = 0; i < occurrences.length; ++i) {
            if (occurrences[i] > 0) {
                return false;
            }
        }
        return true;
    }
}

package org.hryciuk.stayinshape.strings;

public class ValidAnagram {

    // Time complexity: O(n), Space complexity: O(1)
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] firstStringChars = s.toCharArray();
        char[] secondStringChars = t.toCharArray();

        int[] occurrences = new int[26];
        for (int i = 0; i < firstStringChars.length; ++i) {
            occurrences[firstStringChars[i] - 'a']++;
        }

        for (int i = 0; i < secondStringChars.length; ++i) {
            occurrences[secondStringChars[i] - 'a']--;
        }

        for (int i = 0; i < occurrences.length; ++i) {
            if (occurrences[i] > 0) {
                return false;
            }
        }
        return true;
    }
}

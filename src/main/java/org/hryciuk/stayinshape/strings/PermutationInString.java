package org.hryciuk.stayinshape.strings;

public class PermutationInString {

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int first = s1.length(), second = s2.length();
        int[] map = new int[26];
        for(char c : s1.toCharArray()) {
            map[c - 'a']++;
        }
        int l = 0;
        int count = 0; // number of s1 chars counted
        for(int r = 0; r < second; r++) {
            // decrement each char we pass by, if it is a char we want, increment count
            if(map[s2.charAt(r) - 'a']-- > 0) {
                count++;
            }
            // we found a permutation
            if(count == first) return true;
            // check when we get a window equal to size of s1
            if(r - l + 1 == first) {
                // for cases where window has chars we look for but also includes other chars,
                // we put the chars back into the map and decrement count so that we keep looking
                if(map[s2.charAt(l) - 'a']++ >= 0) count--;
                l++; // makes sure that our window size will be equal to s1 after we reach that size
            }
        }
        return false;
    }

    public boolean checkInclusion3(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] map = new int[26];
        for (char c : s1.toCharArray()) {
            map[c - 'a']++;
        }
        int l = 0;
        int count = 0;
        char[] arr = s2.toCharArray();
        for (int r = 0; r < s2.length(); ++r) {
            if (map[arr[r] - 'a'] > 0) {
                count++;
            }
            map[arr[r] - 'a']--;
            if (count == s1.length()) {
                return true;
            }
            if (r - l + 1 == s1.length()) {
                if (map[arr[l] - 'a'] >= 0) {
                    count--;
                }
                map[arr[l] - 'a']++;
                l++;
            }
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Occurrences = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            s1Occurrences[s1.charAt(i) - 'a']++;
        }
        int startOfWindow = 0;
        for (int endOfWindow = 0; endOfWindow < s2.length(); ++endOfWindow) {
            char currentChar = s2.charAt(endOfWindow);
            s1Occurrences[currentChar - 'a']--;
            if (endOfWindow - startOfWindow + 1 > s1.length()) {
                s1Occurrences[s2.charAt(startOfWindow) - 'a']++;
                startOfWindow++;
            }
            if (checkIfAllCharsUsed(s1Occurrences)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfAllCharsUsed(int[] copyOfOccurrences) {
        for (int i = 0; i < copyOfOccurrences.length; ++i) {
            if (copyOfOccurrences[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

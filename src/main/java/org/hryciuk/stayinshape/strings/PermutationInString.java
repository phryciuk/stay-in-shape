package org.hryciuk.stayinshape.strings;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Occurrences = new char[26];
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

    private boolean checkIfAllCharsUsed(char[] copyOfOccurrences) {
        for (int i = 0; i < copyOfOccurrences.length; ++i) {
            if (copyOfOccurrences[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

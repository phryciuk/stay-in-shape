package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        char[] occurrences = new char[26];
        for (int i = 0; i < p.length(); ++i) {
            occurrences[p.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int startOfWindow = 0;
        for (int endOfWindow = 0; endOfWindow < s.length(); ++endOfWindow) {
            char current = s.charAt(endOfWindow);
            occurrences[current - 'a']--;
            if (endOfWindow - startOfWindow + 1 > p.length()) {
                occurrences[s.charAt(startOfWindow) - 'a']++;
                startOfWindow++;
            }
            if (allOccurrencesUsed(occurrences)) {
                result.add(startOfWindow);
            }
        }
        return result;
    }

    private boolean allOccurrencesUsed(char[] occurrences) {
        for (int i = 0; i < occurrences.length; ++i) {
            if (occurrences[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

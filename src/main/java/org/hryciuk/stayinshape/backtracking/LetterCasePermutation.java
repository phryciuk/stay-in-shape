package org.hryciuk.stayinshape.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        permute(s, result, "");
        return new ArrayList<>();
    }

    private void permute(String s, List<String> result, String temp) {

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                String first = Character.toUpperCase(s.charAt(i)) + s.substring(i + 1);
                temp += first;
                String second = Character.toLowerCase(s.charAt(i)) + s.substring(i + 1);
                result.add(first);
                result.add(second);
            }
        }
    }
}


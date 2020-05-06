package org.hryciuk.stayinshape.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        permute(s, result, 0);
        return result;
    }

    private void permute(String s, List<String> result, int position) {
        if (position == s.length() && !result.contains(s)) {
            result.add(s);
        }
        for (int i = position; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                String first = s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1);
                if (!first.equals(s)) {
                    permute(first, result, i + 1);
                }
                String second = s.substring(0, i) + Character.toLowerCase(s.charAt(i)) + s.substring(i + 1);
                if (!second.equals(s)) {
                    permute(second, result, i + 1);
                }
            } else {
                permute(s, result, i + 1);
            }
        }
        if (!result.contains(s)) {
            result.add(s);
        }
    }
}


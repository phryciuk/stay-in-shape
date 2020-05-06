package org.hryciuk.stayinshape.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        permute(chars, result, 0);
        return result;
    }

    private void permute(char[] string, List<String> result, int index) {
        if (index == string.length) {
            result.add(new String(string));
            return;
        }
        if (Character.isDigit(string[index])) {
            permute(string, result, index + 1);
        } else {
            char character = string[index];
            char lowerCase = Character.toLowerCase(character);
            string[index] = lowerCase;
            permute(string, result, index + 1);
            char upperCase = Character.toUpperCase(character);
            string[index] = upperCase;
            permute(string, result, index + 1);
        }
    }
}


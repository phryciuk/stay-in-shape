package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, n, 0, 0 , "");
        return result;
    }

    private void backtrack(List<String> result, int n, int openingParentheses, int closingParentheses, String currentString) {
        if (currentString.length() == n * 2) {
            result.add(currentString);
        }
        if (openingParentheses < n) {
            backtrack(result, n, openingParentheses + 1, closingParentheses, currentString + "(");
        }
        if (closingParentheses < n && closingParentheses < openingParentheses) {
            backtrack(result, n, openingParentheses, closingParentheses + 1, currentString + ")");
        }
    }
}

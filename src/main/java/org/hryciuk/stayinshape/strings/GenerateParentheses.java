package org.hryciuk.stayinshape.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

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

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack2(n, 0, 0, sb, result);
        return result;
    }

    private void backtrack2(int n, int openCount, int closeCount, StringBuilder sb, List<String> result) {
        if (openCount == closeCount && openCount == n) {
            result.add(sb.toString());
            return;
        }

        if (openCount < n) {
            backtrack2(n, openCount + 1, closeCount, sb.append("("), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closeCount < n && closeCount < openCount) {
            backtrack2(n, openCount, closeCount + 1, sb.append(")"), result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

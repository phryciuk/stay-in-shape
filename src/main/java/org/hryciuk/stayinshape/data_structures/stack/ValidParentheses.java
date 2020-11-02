package org.hryciuk.stayinshape.data_structures.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Easy
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                stack.push(charArray[i]);
            } else {
                if (!stack.isEmpty() && getCorrespondingParenthesesEnding(stack.peek()) == charArray[i]) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char getCorrespondingParenthesesEnding(char parentheses) {
        if (parentheses == '(') {
            return ')';
        } else if (parentheses == '[') {
            return ']';
        } else if (parentheses == '{') {
            return '}';
        }
        return '0';
    }
}

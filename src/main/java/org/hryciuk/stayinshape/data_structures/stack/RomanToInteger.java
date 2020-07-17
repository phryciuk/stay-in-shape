package org.hryciuk.stayinshape.data_structures.stack;

import java.util.Stack;

public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] roman = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char current = roman[i];
            stack.push(current);
        }
        char previous = 'z';
        int result = 0;
        while (!stack.isEmpty()) {
            Character popped = stack.pop();
            if (popped == 'M') {
                result += 1000;
            } else if (popped == 'D') {
                result += 500;
            } else if (popped == 'C') {
                if (previous == 'D' || previous == 'M') {
                    result -= 100;
                } else {
                    result += 100;
                }
            } else if (popped == 'L') {
                result += 50;
            } else if (popped == 'X') {
                if (previous == 'L' || previous == 'C') {
                    result -= 10;
                } else {
                    result += 10;
                }
            } else if (popped == 'V') {
                result += 5;
            } else if (popped == 'I') {
                if (previous == 'V' || previous == 'X') {
                    result -= 1;
                } else {
                    result += 1;
                }
            } else {
                result += 0;
            }
            previous = popped;
        }
        return result;
    }
}

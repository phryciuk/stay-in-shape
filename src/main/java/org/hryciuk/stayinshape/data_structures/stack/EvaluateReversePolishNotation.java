package org.hryciuk.stayinshape.data_structures.stack;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int result = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                stack.push(String.valueOf(result));
            } else if (s.equals("*")) {
                int result = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                stack.push(String.valueOf(result));
            } else if (s.equals("-")) {
                String second = stack.pop();
                String first = stack.pop();
                int result = Integer.parseInt(first) - Integer.parseInt(second);
                stack.push(String.valueOf(result));
            } else if (s.equals("/")) {
                String second = stack.pop();
                String first = stack.pop();
                int result = Integer.parseInt(first) / Integer.parseInt(second);
                stack.push(String.valueOf(result));
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.peek());
    }

}

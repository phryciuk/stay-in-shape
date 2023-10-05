package org.hryciuk.stayinshape.data_structures.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int indexOfSmallerTemp = stack.pop();
                result[indexOfSmallerTemp] = i - indexOfSmallerTemp;
            }
            stack.push(i);
        }
        return result;
    }
}

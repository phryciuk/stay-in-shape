package org.hryciuk.stayinshape.data_structures.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public MinStack() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }

    public void push(int val) {
        this.stack.push(val);
        if (!minStack.isEmpty()) {
            val = Math.min(val, minStack.peek());
        }
        this.minStack.push(val);
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}

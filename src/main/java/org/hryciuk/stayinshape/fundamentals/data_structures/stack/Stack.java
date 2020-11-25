package org.hryciuk.stayinshape.fundamentals.data_structures.stack;

/**
 * Stack implementation using array
 */
public class Stack {

    private int[] arr;
    private int top;

    public Stack(int size) {
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int val) {
        arr[++top] = val;
    }

    public int pop() {
        return arr[top--];
    }

    public int peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

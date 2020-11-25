package org.hryciuk.stayinshape.fundamentals.data_structures.stack;

/**
 * Stack implementation using array
 */
public class Stack {

    private int[] arr;
    private int top;


    public Stack(int size) {
        this.arr = new int[size];
        this.top = 0;
    }

    public void push(int val) {
        arr[++top] = val;
    }

    private int pop() {
        return arr[top--];
    }

    private int peek() {
        return arr[top];
    }

    private boolean isEmpty() {
        return top == -1;
    }
}

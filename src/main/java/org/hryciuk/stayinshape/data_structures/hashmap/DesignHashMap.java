package org.hryciuk.stayinshape.data_structures.hashmap;

/**
 * Key things to remember when implementing a hashmap:
 * 1. First node in every bucket is always a dummy node. That helps with removal.
 * 2. When inserting new element, while there is no entry in the bucket list, make sure dummy node is first created, and then the actual value is inserted
 *
 */
public class DesignHashMap {

    private final int SIZE = 1_000;

    private final ListNode[] arr;

    /**
     * Initialize your data structure here.
     */
    public DesignHashMap() {
        this.arr = new ListNode[SIZE];
    }
    public void put(int key, int value) {
        remove(key);
        int index = hash(key);
        ListNode current = this.arr[index];
        if (current == null) {
            this.arr[index] = new ListNode(key, value);
        } else {
            ListNode prev = new ListNode(-1, -1);
            while (current != null && key < current.key) {
                prev = current;
                current = current.next;
            }
            if (current == null) {
                prev.next = new ListNode(key, value);
            }
            if (key >= current.key) {
                ListNode newOne = new ListNode(key, value);
                prev.next = newOne;
                newOne.next = current;
            }
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (this.arr[index] == null) {
            return -1;
        }
        ListNode current = this.arr[index];
        while (current != null && current.key != key) {
            current = current.next;
        }
        if (current.key == key) {
            return current.val;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (this.arr[index] == null) {
            return;
        }
        ListNode current = this.arr[index];
        ListNode prev = null;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            this.arr[index] = null;
        } else {
            ListNode prevNext = prev.next;
            if (prevNext == null) {
                prev.next = null;
            } else {
                prev.next = prevNext.next;
            }

        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

}

class ListNode {
    ListNode next;
    int key;
    int val;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

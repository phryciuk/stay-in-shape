package org.hryciuk.stayinshape.data_structures.hashmap;

public class DesignHashMap {

    private final int SIZE = 1_000;

    private final ListNode[] buckets;

    /**
     * Initialize your data structure here.
     */
    public DesignHashMap() {
        this.buckets = new ListNode[SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hash(key);
        if (this.buckets[index] == null) {
            this.buckets[index] = new ListNode(-1, -1);
        }
        ListNode found = findKey(this.buckets[index], key);
        if (found.next == null) {
            found.next = new ListNode(key, value);
        } else {
            found.next.val = value;
        }
    }

    private ListNode findKey(ListNode list, int key) {
        ListNode current = list;
        ListNode prev = null;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = hash(key);
        ListNode current = buckets[hash];
        if (current == null) {
            return -1;
        }
        ListNode found = findKey(current, key);
        return found.next != null ? found.next.val : -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = hash(key);
        ListNode list = this.buckets[hash];
        if (list == null) {
            return;
        }
        ListNode prev = findKey(list, key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }

    private int hash(int val) {
        return Integer.hashCode(val) % SIZE;
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

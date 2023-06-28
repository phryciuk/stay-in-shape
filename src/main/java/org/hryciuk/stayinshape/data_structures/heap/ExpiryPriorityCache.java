package org.hryciuk.stayinshape.data_structures.heap;

import java.util.*;

class Item {
    String key;
    String value;
    int expiration;
    int priority;
    public Item(String key, String value, int priority, int expireAfter) {
        this.priority = priority;
        this.expiration = expireAfter;
        this.key = key;
        this.value = value;
    }
}

class ListNode<T> {
    T data;
    ListNode<T> prev;
    ListNode<T> next;

    ListNode(T data) {
        this(data, null, null);
    }

    ListNode(T data, ListNode<T> next, ListNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList<T> {
    ListNode<T> front;
    ListNode<T> back;
    int size;

    DoublyLinkedList() {
    }

    ListNode<T> addFront(T item) {
        ListNode<T> newOne = new ListNode<>(item);
        if (this.size == 0) {
            this.front = newOne;
            this.back = this.front;
        } else {
            newOne.next = front;
            front.prev = newOne;
            this.front = newOne;
        }
        return newOne;
    }

    ListNode<T> removeBack() {
        ListNode<T> back = this.back;
        this.back = this.back.prev;
        this.size--;
        return back;
    }

    void remove(ListNode<T> item) {
        if (this.size == 0) {
            return;
        }
        if (size == 1) {
            this.front = this.back = item = null;
        }
        ListNode<T> next = item.next;
        ListNode<T> prev = item.prev;
        if (next != null) {
            next.prev = prev;
        }
        if (prev != null) {
            prev.next = next;
        }
        item = null;
        this.size--;
    }
}

public class ExpiryPriorityCache {

    private int size;
    private int capacity;

    private Map<String, ListNode<Item>> items;
    private PriorityQueue<ListNode<Item>> expirationMinHeap;
    private PriorityQueue<ListNode<Item>> priorityMinHeap;

    private Map<Integer, DoublyLinkedList<Item>> priorityToLru; // at the top most recently used; at back LRU

    public ExpiryPriorityCache(int capacity) {
        this.size = 0;
        this.capacity = 0;
        this.items = new HashMap<>();
        this.expirationMinHeap = new PriorityQueue<>((a, b) -> a.data.expiration - b.data.expiration);
        this.priorityMinHeap = new PriorityQueue<>((a, b) -> a.data.priority - b.data.priority);
    }

    // O(1)
    public Item get(String key) {
        if (items.containsKey(key)) {
            ListNode<Item> itemNode = items.get(key);
            Item item = itemNode.data;

            DoublyLinkedList<Item> list = this.priorityToLru.get(item.priority);
            list.remove(itemNode);
            list.addFront(item);
        }
        return null;
    }

    public void evictItem(int currentTime) {
        if (this.size == 0) {
            return;
        }
        int expiration = expirationMinHeap.peek().data.expiration;
        if (currentTime >= expiration) {
            // item is expired;
            // 1. remove from this q
            ListNode<Item> expiredItemNode = expirationMinHeap.poll();
            // 2. remove from priority map;
            DoublyLinkedList<Item> list = this.priorityToLru.get(expiredItemNode.data.priority);
            list.remove(expiredItemNode);
            if (list.size == 0) {
                this.priorityToLru.remove(expiredItemNode.data.priority);
            }
            // 3. remove from priority min heap
            this.priorityMinHeap.remove(expiredItemNode);
            // 4. remove from items
            this.items.remove(expiredItemNode.data.key);
            this.size--;
            return;
        }
        // if item is not expired we take the peek from priority minHeap
        ListNode<Item> lowestPriority = this.priorityMinHeap.poll();
        // remove LRU
        DoublyLinkedList<Item> lowestPriorityList = this.priorityToLru.get(lowestPriority.data.priority);
        ListNode<Item> lruNode = lowestPriorityList.removeBack();
        if (lowestPriorityList.size == 0) {
            this.priorityToLru.remove(lruNode.data.priority);
        }
        // remove from expiry min heap
        this.expirationMinHeap.remove(lruNode);
        // remove from items
        this.items.remove(lruNode.data.key);
        this.size--;
    }

    public void setItem(Item item, int currentTime) {
        if (this.size == this.capacity) {
            evictItem(currentTime);
        }

        DoublyLinkedList<Item> list = null;
        if (this.priorityToLru.containsKey(item.priority)) {
            list = this.priorityToLru.get(item.priority);
        } else {
            list = new DoublyLinkedList<>();
            this.priorityToLru.put(item.priority, list);
        }

        ListNode<Item> addedNode = list.addFront(item);

        //key-item map
        this.items.put(item.key, addedNode);
        this.priorityMinHeap.add(addedNode);
        this.expirationMinHeap.add(addedNode);
        this.size++;
    }

    public Set<String> getKeys() {
        return items.keySet();
    }

}

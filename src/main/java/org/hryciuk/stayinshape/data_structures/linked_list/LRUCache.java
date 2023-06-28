package org.hryciuk.stayinshape.data_structures.linked_list;

import java.util.HashMap;
import java.util.Map;

// HashMap + Doubly Linked List
public class LRUCache {

    private final int size;
    Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if (node != null) {
            result = node.value;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            if (map.size() == this.size) {
                map.remove(tail.prev.key); // IMPORTANT. First you need to remove the element from the map
                                           // and then from the list.
                                           // Otherwise you are removing wrong element from the map
                remove(tail.prev);
            }
            Node newOne = new Node();
            newOne.key = key;
            newOne.value = value;
            add(newOne);
            map.put(key, newOne);
        }
    }

    private void add(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

class Node {
    Node next;
    Node prev;
    int value;
    int key;
}



package org.hryciuk.stayinshape.data_structures.linked_list;

import java.util.HashMap;
import java.util.Map;

// HashMap + Doubly Linked List
public class LRUCache {

    private final int size;
    Map<Integer, CacheNode> map;
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        this.head = new CacheNode();
        this.tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        CacheNode node = map.get(key);
        if (node != null) {
            result = node.value;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        CacheNode node = map.get(key);
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
            CacheNode newOne = new CacheNode();
            newOne.key = key;
            newOne.value = value;
            add(newOne);
            map.put(key, newOne);
        }
    }

    private void add(CacheNode node) {
        CacheNode next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }

    private void remove(CacheNode node) {
        CacheNode prevCacheNode = node.prev;
        CacheNode nextCacheNode = node.next;
        prevCacheNode.next = nextCacheNode;
        nextCacheNode.prev = prevCacheNode;
    }
}

class CacheNode {
    CacheNode next;
    CacheNode prev;
    int value;
    int key;
}



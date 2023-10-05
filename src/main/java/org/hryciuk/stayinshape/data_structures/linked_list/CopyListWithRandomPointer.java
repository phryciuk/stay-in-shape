package org.hryciuk.stayinshape.data_structures.linked_list;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
 class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node current = head;
        Map<Node, Node> originalToCopy = new HashMap<>();
        while (current != null) {
            Node copy = new Node(current.val);
            originalToCopy.put(current, copy);
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copy = originalToCopy.get(current);
            copy.next = originalToCopy.getOrDefault(current.next, null);
            copy.random = originalToCopy.getOrDefault(current.random, null);
            current = current.next;
        }

        return originalToCopy.get(head);
    }
}

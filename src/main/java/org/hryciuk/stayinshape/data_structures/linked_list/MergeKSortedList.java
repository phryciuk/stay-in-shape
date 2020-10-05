package org.hryciuk.stayinshape.data_structures.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(listnode -> listnode.val));
        for (ListNode list : lists) {
            ListNode current = list;
            while (current != null) {
                heap.add(current);
                current = current.next;
            }
        }

        ListNode prev = new ListNode();
        ListNode start = prev;
        ListNode current = prev.next;
        while(!heap.isEmpty()) {
            current = heap.poll();
            current.next = null;
            prev.next = current;
            prev = current;
        }
        return start.next;
    }
}

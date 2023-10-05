package org.hryciuk.stayinshape.data_structures.linked_list;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode node = groupPrev;
            for (int i = 0; i < k; ++i) {
                if (node != null) {
                    node = node.next;
                } else {
                    break;
                }
            }
            if (node == null) {
                break;
            }

            ListNode prev = null;
            ListNode current = groupPrev.next;
            for (int i = 0; i < k; ++i) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            ListNode tail = groupPrev.next;
            tail.next = current;
            groupPrev.next = prev;
            groupPrev = tail;
        }
        return dummy.next;
    }
}

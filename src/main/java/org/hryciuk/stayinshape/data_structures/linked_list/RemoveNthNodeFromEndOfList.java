package org.hryciuk.stayinshape.data_structures.linked_list;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        ListNode slow = dummy;
        ListNode fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}

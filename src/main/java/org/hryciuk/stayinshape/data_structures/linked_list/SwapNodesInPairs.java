package org.hryciuk.stayinshape.data_structures.linked_list;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Note:
 *
 *     Your algorithm should use only constant extra space.
 *     You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPrev = dummy;
        ListNode first = head;
        ListNode second = head.next;

        while (first != null && first.next != null && second != null) {
            ListNode secondNext = second.next;
            firstPrev.next = second;
            first.next = secondNext;
            second.next = first;
            firstPrev = first;
            first = first.next;
            second = first != null ? first.next : null;
        }

        return dummy.next;
    }
}

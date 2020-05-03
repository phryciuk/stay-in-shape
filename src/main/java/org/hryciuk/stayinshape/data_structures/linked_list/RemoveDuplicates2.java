package org.hryciuk.stayinshape.data_structures.linked_list;

//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//        For example,
//        Given 1->2->3->3->4->4->5, return 1->2->5.
//        Given 1->1->1->2->3, return 2->3.
class RemoveDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.val == current.val) {
                current = current.next;
            }
            if (pre.next == current) {
                pre = pre.next;
            } else {
                pre.next = current.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}

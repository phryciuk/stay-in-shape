package org.hryciuk.stayinshape.data_structures.linked_list;

/**
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.
 *  For example,
 *  Given 1->1->2, return 1->2.
 *  Given 1->1->2->3->3, return 1->2->3.
 */
class RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null) {
      ListNode next = current.next;
      while (next != null && current.val == next.val) {
        next = next.next;
      }
      current.next = next;
      current = current.next;
    }
    return head;
  }
}

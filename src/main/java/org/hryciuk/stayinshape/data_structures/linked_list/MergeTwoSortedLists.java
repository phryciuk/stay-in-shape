package org.hryciuk.stayinshape.data_structures.linked_list;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      current = current.next;
    }

    if (list1 != null) {
      current.next = list1;
    } else if (list2 != null) {
      current.next = list2;
    }
    return dummy.next;
  }
}

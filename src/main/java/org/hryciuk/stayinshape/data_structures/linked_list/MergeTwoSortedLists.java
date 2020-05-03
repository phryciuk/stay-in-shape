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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode currentL1 = l1;
    ListNode currentL2 = l2;
    ListNode newHead = null;

    if (currentL1 == null) {
      if (currentL2 == null) {
        return null;
      }
      return currentL2;
    }
    if (currentL2 == null) {
      return currentL1;
    }

    if (currentL1.val <= currentL2.val) {
      newHead = currentL1;
    } else {
      newHead = currentL2;
    }

    while (currentL1 != null && currentL2 != null) {
      if (currentL1.val <= currentL2.val) {
        while (currentL1.next != null && currentL1.next.val <= currentL2.val) {
          currentL1 = currentL1.next;
        }
        ListNode nextOne = currentL1.next;
        currentL1.next = currentL2;
        currentL1 = nextOne;
      } else {
        while (currentL2.next != null && currentL2.next.val <= currentL1.val) {
          currentL2 = currentL2.next;
        }
        ListNode nextOne = currentL2.next;
        currentL2.next = currentL1;
        currentL2 = nextOne;
      }
    }
    return newHead;
  }
}

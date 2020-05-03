package org.hryciuk.stayinshape.data_structures.linked_list;

class RemoveLinkedListElements {

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(-1); // dummy element;

    ListNode current = head;
    dummy.next = current;

    ListNode prev = dummy;
    while (current != null) {
      if (current.val == val) {
        prev.next = current.next;
      } else {
        prev = prev.next;
      }
      current = current.next;
    }
    return dummy.next;
  }

}

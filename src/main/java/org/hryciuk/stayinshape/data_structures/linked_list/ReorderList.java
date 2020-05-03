package org.hryciuk.stayinshape.data_structures.linked_list;

class ReorderList {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    // szukamy połowy listy
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // odwracamy drugą połowę listy
    ListNode secondHalf = null;
    ListNode current = slow;
    while (current != null) {
      ListNode next = current.next;
      current.next = secondHalf;
      secondHalf = current;
      current = next;
    }

    // zamieniamy wskaźniki
    ListNode beginning = head;
    while (beginning != null && secondHalf != null && secondHalf.next != null) {
      ListNode anotherNext = beginning.next;
      ListNode prevNext = secondHalf.next;
      beginning.next = secondHalf;
      secondHalf.next = anotherNext;
      secondHalf = prevNext;
      beginning = anotherNext;
    }
    return;
  }
}

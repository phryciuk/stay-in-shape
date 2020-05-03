package org.hryciuk.stayinshape.data_structures.linked_list;

class PalindromeLinkedList {

  boolean isPalindrome(ListNode head) {
    if (head == null) {
      return false;
    }

    // znajdujemy środek listy.
    ListNode slow = head;
    ListNode fast = head;

    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // odwracamy drugą połowę listy
    ListNode prev = null;
    ListNode midCurrent = slow;
    while (midCurrent != null) {
      ListNode next = midCurrent.next;
      midCurrent.next = prev;
      prev = midCurrent;
      midCurrent = next;
    }

    // sprawdzamy czy wartości się zgadzają
    ListNode middle = prev;
    ListNode originalBegin = head;

    while (middle != null && originalBegin != null) {
      if (middle.val != originalBegin.val) {
        return false;
      }
      middle = middle.next;
      originalBegin = originalBegin.next;
    }
    return true;
  }

}

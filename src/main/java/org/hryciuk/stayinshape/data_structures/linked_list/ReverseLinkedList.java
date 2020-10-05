package org.hryciuk.stayinshape.data_structures.linked_list;

class ReverseLinkedList {

  private static ListNode SINGLY_LINKED_LIST = LinkedListUtil.createSinglyLinkedList();

  ListNode reverseLinkedList(ListNode node) {
    ListNode previous = null;
    ListNode current = node;
    ListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  /*
   1) Divide the list in two parts - first node and rest of the linked list.
   2) Call reverse for the rest of the linked list.
   3) Link rest to first.

   What is the reverse of an n element list?
   the reverse of the second element on followed by the first element.
   */
  ListNode reverseLinkedListRecursively(ListNode node) {
    if (node == null) {  // What is the reverse of null (the empty list)? null.
      return null;
    }
    if (node.next == null) { // What is the reverse of a one element list? the element.
      return node;
    }
    ListNode second = node.next; // get the rest of the list
    ListNode reversed = reverseLinkedListRecursively(second);

    second.next = node; //second is now the last element in the reversed list. next element is the first one.
    node.next = null; // adjust pointer

    return reversed;
  }

  ListNode reverseLinkedListRecursively2(ListNode node) {
    if (node == null) {
      return null;
    }
    if (node.next == null) {
      return node;
    }
    ListNode reversed = reverseLinkedListRecursively2(node.next);
    node.next.next = node;
    node.next = null;
    return reversed;
  }

}

package org.hryciuk.stayinshape.data_structures.linked_list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

class LinkedListUtil {

  private static final Logger log = LoggerFactory.getLogger(LinkedListUtil.class);

  static ListNode createSinglyLinkedList() {
    return createSinglyLinkedList(1,2,3,4,5);
  }

  static ListNode createSinglyLinkedList(int... val) {
    ListNode prev = new ListNode(0);
    ListNode first = prev;
    for (int i : val) {
      ListNode newOne = new ListNode(i);
      prev.next = newOne;
      prev = newOne;
    }
    return first.next;
  }

  static void printList(ListNode listNode) {
    Objects.requireNonNull(listNode);
    ListNode current = listNode;
    while (current != null) {
      log.info(String.valueOf(current.getVal()));
      current = current.next;
    }
  }

  static String buildStringFromListNode(ListNode listNode) {
    if (listNode == null) {
      return "";
    }
    ListNode current = listNode;
    StringBuilder sb = new StringBuilder();
    while (current != null) {
      sb.append(current.val);
      if (current.next != null) {
        sb.append(",");
      }
      current = current.next;
    }
    return sb.toString();
  }

}

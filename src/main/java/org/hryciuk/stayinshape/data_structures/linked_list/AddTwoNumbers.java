package org.hryciuk.stayinshape.data_structures.linked_list;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = 0;
    ListNode first = l1;
    ListNode second = l2;

    ListNode newOne = new ListNode(-1); // dummy
    ListNode current = newOne;

    while (first != null || second != null) {

      if (first != null) {
        sum += first.val;
        first = first.next;
      }

      if (second != null) {
        sum += second.val;
        second = second.next;
      }

      int mod = sum % 10; // obliczanie cyfry jedności

      ListNode toAdd = new ListNode(mod);
      current.next = toAdd;
      current = toAdd;

      sum = sum / 10; // przesunięcie liczby dziesiątek dalej
    }

    if (sum > 0) {
      ListNode toAdd = new ListNode(sum);
      current.next = toAdd;
    }

    return newOne.next;
  }

}

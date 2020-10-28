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

  public ListNode addTwoNumbersRecursively(ListNode l1, ListNode l2) {
    return addTwoNumberRec(l1, l2, 0);
  }

  private ListNode addTwoNumberRec(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null) {
      if (carry == 0) {
        return null;
      } else {
        return new ListNode(carry);
      }
    } else if (l1 == null) {
      l1 = new ListNode(0);
    } else if (l2 == null) {
      l2 = new ListNode(0);
    }
    int val = 0;
    val += l1.val + l2.val + carry;
    carry = val / 10;
    int remainder = val % 10;
    ListNode created = new ListNode(remainder);
    created.next = addTwoNumberRec(l1.next, l2.next, carry);
    return created;
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode last = new ListNode(-1);
    ListNode start = last;
    while (l1 != null || l2 != null) {
      int val = 0;
      if (l1 != null) {
        val += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        val += l2.val;
        l2 = l2.next;
      }
      val += carry;

      carry = val / 10;
      int remainder = val % 10;
      ListNode newOne = new ListNode(remainder);
      last.next = newOne;
      last = newOne;
    }

    if (carry > 0) {
      ListNode first = new ListNode(carry);
      last.next = first;
    }
    return start.next;
  }


}

package org.hryciuk.stayinshape.data_structures.linked_list;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                      ↘
 *                         c1 → c2 → c3
 *                      ↗
 *
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
class IntersectionOfTwoLinkedLists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // zliczamy liczbę elementów w obydwu listach
    int numberOfAElements = countElements(headA);
    int numberOfBElements = countElements(headB);
    // liczymy różnicę w długości
    int diff = Math.abs(numberOfAElements - numberOfBElements);

    // Tworzymy 2 nowe wskaźniki. Pierwszy to head krótszej listy, drugi to head po przesunięciu o różnicę.
    ListNode starter = null;
    ListNode otherPointer = null;
    if (numberOfAElements > numberOfBElements) {
      starter = headA;
      for (int i = 0; i < diff; ++i) {
        starter = starter.next;
      }
      otherPointer = headB;
    } else {
      starter = headB;
      for (int i = 0; i < diff; ++i) {
        starter = starter.next;
      }
      otherPointer = headA;
    }

    // Potem sprawdzamy po kolei czy element jest ten sam.
    while (starter != null && otherPointer != null) {
      if (starter.val == otherPointer.val) {
        return starter;
      }
      starter = starter.next;
      otherPointer = otherPointer.next;
    }
    return null;
  }

  private int countElements(ListNode head) {
    int numberOfElements = 0;
    while (head != null) {
      head = head.next;
      numberOfElements++;
    }
    return numberOfElements;
  }

}

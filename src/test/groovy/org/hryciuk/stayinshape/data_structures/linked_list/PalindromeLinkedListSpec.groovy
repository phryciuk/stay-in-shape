package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification

class PalindromeLinkedListSpec extends Specification {

  def "should tell that a list is palindromic"(int[] values) {
    given:
    def list = LinkedListUtil.createSinglyLinkedList(values)
    LinkedListUtil.printList(list)
    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList()

    expect:
    palindromeLinkedList.isPalindrome(list)

    where:
    values             | _
    [1, 2, 3, 2, 1]    | _
    [1, 2, 3, 3, 2, 1] | _
    [1]                | _
    [1, 2, 1]          | _
  }

  def "should tell that a list is not palindromic"(int[] values) {
    given:
    def list = LinkedListUtil.createSinglyLinkedList(values)
    LinkedListUtil.printList(list)
    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList()

    expect:
    !palindromeLinkedList.isPalindrome(list)

    where:
    values              | _
    [1, 2, 3]           | _
    [1, 2, 3, 13, 2, 1] | _
    [1, 4]              | _
    [12, 1, 1]          | _
  }

}

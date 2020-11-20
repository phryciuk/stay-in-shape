package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification

class ReverseLinkedListSpec extends Specification {

  def "should reverse a singly linked list"() {
    given: "we create a 1->2->3->4->5 singly linked list"
    def list = LinkedListUtil.createSinglyLinkedList()
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList()

    when:
    def reversed = reverseLinkedList.reverseLinkedList(list)

    then: "prints in reversed order"
    LinkedListUtil.printList(reversed)
  }

  def "should reverse a singly linked list recursively"() {
    given: "we create a 1->2->3->4->5 singly linked list"
    def list = LinkedListUtil.createSinglyLinkedList()
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList()

    when:
    def reversed = reverseLinkedList.reverseLinkedListRecursively(list)

    then: "prints in reversed order"
    LinkedListUtil.printList(reversed)
  }

  def "should reverse a singly linked list recursively using second method"() {
    given: "we create a 1->2->3->4->5 singly linked list"
    def list = LinkedListUtil.createSinglyLinkedList()
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList()

    when:
    def reversed = reverseLinkedList.reverseLinkedListRecursively2(list)

    then: "prints in reversed order"
    LinkedListUtil.printList(reversed)
  }
}

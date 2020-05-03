package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification

class RemoveLinkedListElementsSpec extends Specification {

  def "should delete elements with a given value from the list"() {
    given:
    def list = LinkedListUtil.createSinglyLinkedList(1,2,3,4,6,5,6,7,6,6,6)
    RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();

    when:
    def withoutRemoveElements = removeLinkedListElements.removeElements(list, 6)

    then:
    LinkedListUtil.printList(withoutRemoveElements)
  }

  def "should delete elements with a given value from the list that has only 1 element"() {
    given:
    def list = LinkedListUtil.createSinglyLinkedList(1)
    RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();

    when:
    def withoutRemoveElements = removeLinkedListElements.removeElements(list, 1)

    then:
    withoutRemoveElements == null

  }
}

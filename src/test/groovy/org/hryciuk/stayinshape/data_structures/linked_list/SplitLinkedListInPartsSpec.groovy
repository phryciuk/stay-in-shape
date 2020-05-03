package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification

class SplitLinkedListInPartsSpec extends Specification {

  def "should split linked list in parts"() {
    given:
    def list = LinkedListUtil.createSinglyLinkedList(values.toArray(new int[values.size()]))
    LinkedListUtil.printList(list)
    SplitLinkedListInParts splitLinkedListInParts = new SplitLinkedListInParts()

    expect:
    def actual = splitLinkedListInParts.splitListToParts(list, 3)
    actual.length == 3

    where:
    values                          | _
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | _
  }

}

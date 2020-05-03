package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.linked_list.LinkedListUtil.buildStringFromListNode
import static org.hryciuk.stayinshape.data_structures.linked_list.LinkedListUtil.createSinglyLinkedList


class ReorderListSpec extends Specification {

  def "should reorder list based on specification"() {
    given:
    def list = createSinglyLinkedList(1, 2, 3, 4, 5, 6)
    ReorderList reorderList = new ReorderList();

    when:
    reorderList.reorderList(list);

    then:
    def actual = buildStringFromListNode(list)
    actual == "1,6,2,5,3,4"

  }
}

package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.linked_list.LinkedListUtil.createSinglyLinkedList


class RemoveDuplicatesFromSortedListSpec extends Specification {
  def "should delete duplicates from the sorted linked list"(list, expected) {
    given:
    RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList()

    expect:
    def actual = removeDuplicatesFromSortedList.deleteDuplicates(list)
    LinkedListUtil.buildStringFromListNode(actual) == expected

    where:
    list                                  | expected
    createSinglyLinkedList(1, 1, 2)       | "1,2"
    createSinglyLinkedList(1, 1, 2, 3, 3) | "1,2,3"
  }
}

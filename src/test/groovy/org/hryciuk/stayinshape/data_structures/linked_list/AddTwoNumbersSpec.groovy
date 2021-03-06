package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification
import spock.lang.Unroll

import static org.hryciuk.stayinshape.data_structures.linked_list.LinkedListUtil.createSinglyLinkedList


class AddTwoNumbersSpec extends Specification {

    @Unroll
    def "should add two numbers"(ListNode firstList, ListNode secondList, String expected) {
        given:
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers()

        when:
        def result = addTwoNumbers.addTwoNumbers(firstList, secondList)

        then:
        LinkedListUtil.buildStringFromListNode(result) == expected

        where:
        firstList                                   | secondList                         | expected
        createSinglyLinkedList(2, 4, 3)             | createSinglyLinkedList(5, 6, 4)    | "7,0,8"
        createSinglyLinkedList(1, 2, 2)             | createSinglyLinkedList(9, 6, 4)    | "0,9,6"
        createSinglyLinkedList(9, 9, 9)             | createSinglyLinkedList(9, 9)       | "8,9,0,1"
        createSinglyLinkedList(9, 9, 9, 9, 9, 9, 9) | createSinglyLinkedList(9, 9, 9, 9) | "8,9,9,9,0,0,0,1"
    }


}

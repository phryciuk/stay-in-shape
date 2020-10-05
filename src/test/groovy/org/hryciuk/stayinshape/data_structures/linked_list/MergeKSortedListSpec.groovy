package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification
import spock.lang.Unroll

class MergeKSortedListSpec extends Specification {
    @Unroll
    def "should merge k sorted lists"(int[][] input, int[] expected) {

        given:
        MergeKSortedList mergeKSortedList = new MergeKSortedList()

        when:
        ListNode[] lists = ListNodeUtil.createArrayOfLists(input);
        ListNode actual = mergeKSortedList.mergeKLists(lists)

        then:
        ListNodeUtil.equal(actual, ListNodeUtil.createListNode(expected))

        where:
        input                          | expected
        [[-2, -1, -1, -1], []]         | [-2, -1, -1, -1]
        [[1, 4, 5], [1, 3, 4], [2, 6]] | [1, 1, 2, 3, 4, 4, 5, 6]
        []                             | []
        [[]]                           | []
    }
}

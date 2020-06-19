package org.hryciuk.stayinshape.data_structures.heap

import spock.lang.Specification

class HeapSortTest extends Specification {

    def "should heap sort"(int[] input, int[] expected) {
        given:
        HeapSort heapSort = new HeapSort()

        when:
        heapSort.heapSort(input)

        then:
        input == expected

        where:
        input                                      | expected
        [2, 1, 5, 4, 3, 7]                         | [1, 2, 3, 4, 5, 7]
        [6, 4, 5, 1, 3, 2, 9, 7, 8]                | [1, 2, 3, 4, 5, 6, 7, 8, 9]
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]            | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        [6, 5, 6, 6, 6, 3, 2, 3, 1, 7, 9, 6, 7, 9] | [1, 2, 3, 3, 5, 6, 6, 6, 6, 6, 7, 7, 9, 9]
    }
}

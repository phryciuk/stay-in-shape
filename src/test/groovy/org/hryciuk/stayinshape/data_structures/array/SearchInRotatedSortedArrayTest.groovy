package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class SearchInRotatedSortedArrayTest extends Specification {
    def "should search for an element in rotated sorted array"(int[] input, int target, int expected) {
        given:
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray()

        when:
        def actual = searchInRotatedSortedArray.search(input, target)

        then:
        actual == expected

        where:
        input                 | target | expected
        [4, 5, 6, 7, 0, 1, 2] | 7      | 3
        [4, 5, 6, 7, 0, 1, 2] | 0      | 4
        [4, 5, 6, 7, 0, 1, 2] | 3      | -1
    }
}

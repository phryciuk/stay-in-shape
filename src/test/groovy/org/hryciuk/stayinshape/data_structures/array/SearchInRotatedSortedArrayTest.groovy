package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class SearchInRotatedSortedArrayTest extends Specification {
    @Unroll
    def "should search for an element in rotated sorted array"(int[] input, int target, int expected) {
        given:
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray()

        when:
        def actual = searchInRotatedSortedArray.searchOne(input, target)

        then:
        actual == expected

        where:
        input                 | target | expected
        [1, 3, 5]             | 3      | 1
        [1, 3]             | 0      | -1
        [1, 3]             | 1      | 0
        [4, 5, 6, 7, 0, 1, 2] | 7      | 3
        [4, 5, 6, 7, 0, 1, 2] | 0      | 4
        [4, 5, 6, 7, 0, 1, 2] | 3      | -1
        [1]                   | 0      | -1
        [5, 1, 3]             | 5      | 0
        [0, 1]                | 0      | 0
        [0, 1]                | 1      | 1
        [0, 1]                | 2      | -1
    }
}

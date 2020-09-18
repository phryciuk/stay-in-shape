package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class FindFirstAndLastPositionOfElementInSortedArrayTest extends Specification {
    @Unroll
    def 'should find first and last position of element in sorted array'(int[] input, int target, int[] expected) {
        given:
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray()

        when:
        int[] actual = findFirstAndLastPositionOfElementInSortedArray.searchRange(input, target)

        then:
        Arrays.equals(actual, expected)

        where:
        input               | target || expected
        [2, 2]              | 3      || [-1, -1]
        [5, 7, 7, 8, 8, 10] | 6      || [-1, -1]
        [5, 7, 7, 8, 8, 10] | 8      || [3, 4]
        []                  | 1      || [-1, -1]

    }
}

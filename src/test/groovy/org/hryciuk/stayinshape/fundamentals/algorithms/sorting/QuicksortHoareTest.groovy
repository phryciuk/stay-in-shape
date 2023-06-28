package org.hryciuk.stayinshape.fundamentals.algorithms.sorting

import spock.lang.Specification

class QuicksortHoareTest extends Specification {
    def 'should sort elements using quicksort algorithm'(int[] input, int[] expected) {
        given:
        QuicksortHoare quickSort = new QuicksortHoare()

        when:
        quickSort.sort(input)

        then:
        input == expected

        where:
        input                                         || expected
        [50, 70, 60, 90, 40, 80, 10, 20, 30]                                  || [10, 20, 30, 40, 50, 60, 70, 80, 90]
        [5,4,9,3,8,7] || [3,4,5,7,8,9]
        [4, 1, 2, 3]                                  || [1, 2, 3, 4]
        [7, 3, 5, 1, 4, 6, 2]                         || [1, 2, 3, 4, 5, 6, 7]
        [8, 3, 1, 2, 4, 6, 5]                         || [1, 2, 3, 4, 5, 6, 8]
        [10, 16, 8, 12, 15, 6, 3, 9, 5]               || [3, 5, 6, 8, 9, 10, 12, 15, 16]
        [91, 103, 110, 111, 116, 118, 31, 46, 67, 87] || [31, 46, 67, 87, 91, 103, 110, 111, 116, 118]

    }
}

package org.hryciuk.stayinshape.sorting

import spock.lang.Specification

class QuickSortTest extends Specification {

    def 'should sort elements using quicksort algorithm'(int[] input, int[] expected) {
        given:
        QuickSort quickSort = new QuickSort(input)

        when:
        quickSort.quickSort(0, input.length - 1)

        then:
        input == expected

        where:
        input                 || expected
        [4, 1, 2, 3]          || [1, 2, 3, 4]
        [7, 3, 5, 1, 4, 6, 2] || [1, 2, 3, 4, 5, 6, 7]
    }
}

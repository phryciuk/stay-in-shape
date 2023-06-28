package org.hryciuk.stayinshape.fundamentals.algorithms.sorting

import spock.lang.Specification

class MergeSortTest extends Specification {


    def 'should sort elements using mergesort algorithm'(int[] input, int[] expected) {
        given:
        MergeSort mergeSort = new MergeSort()

        when:
        mergeSort.mergeSort(input, 0, input.length - 1)

        then:
        input == expected

        where:
        input                           || expected
        [4, 1, 2, 3]                    || [1, 2, 3, 4]
        [7, 3, 5, 1, 4, 6, 2]           || [1, 2, 3, 4, 5, 6, 7]
        [8, 3, 1, 2, 4, 6, 5]           || [1, 2, 3, 4, 5, 6, 8]
        [10, 16, 8, 12, 15, 6, 3, 9, 5] || [3, 5, 6, 8, 9, 10, 12, 15, 16]
        [3, 1, 2, 4, 1, 5, 6, 2, 4]     || [1, 1, 2, 2, 3, 4, 4, 5, 6]
    }


}

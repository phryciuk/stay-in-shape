package org.hryciuk.stayinshape.algorithms.binary_search

import spock.lang.Specification

class MedianOfTwoSortedArraysTest extends Specification {
    def "should find median of two sorted arrays"(int[] arr1, int[] arr2, double expected) {
        given:
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays()

        when:
        double actual = median.findMedianSortedArrays(arr1, arr2)

        then:
        actual == expected

        where:
        arr1            | arr2                || expected
//        [1, 3]          | [2]                 || 2.0
//        [1, 2]          | [3, 4]              || 2.5
//        [7, 12, 14, 15] | [1, 2, 3, 4, 9, 11] || 8.0
//        []              | [1]                 || 1.0
        [2]             | []                  || 2.0

    }
}

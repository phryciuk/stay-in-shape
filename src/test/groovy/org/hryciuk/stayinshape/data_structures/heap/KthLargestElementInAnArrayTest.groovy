package org.hryciuk.stayinshape.data_structures.heap

import spock.lang.Specification

class KthLargestElementInAnArrayTest extends Specification {
    def 'should return kth largest element in an array'(int[] input, int k, int expected) {
        given:
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray()

        when:
        def actual = kthLargestElementInAnArray.findKthLargest(input, k)

        then:
        actual == expected

        where:
        input                       | k | expected
        [3, 2, 1, 5, 6, 4]          | 2 | 5
        [3, 2, 1, 5, 6, 4]          | 3 | 4
        [3, 2, 1, 5, 6, 4]          | 6 | 1
        [3, 2, 3, 1, 2, 4, 5, 5, 6] | 4 | 4
        [3, 1, 2, 4]                | 2 | 3
    }
}

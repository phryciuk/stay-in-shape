package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class MergeSortedArrayTest extends Specification {
    @Unroll
    def 'should merge sorted arrays'(int[] nums1, int[] nums2, int m, int n) {
        given:
        MergeSortedArray mergeSortedArray = new MergeSortedArray()

        when:
        mergeSortedArray.merge(nums1, nums2, m, n)

        then:
        Arrays.equals(nums1, expected.stream().mapToInt(i -> i).toArray())

        where:
        nums1              | nums2     | m | n || expected
        [1, 2, 3, 0, 0, 0] | [2, 5, 6] | 3 | 3 || [1, 2, 2, 3, 5, 6]
        [1]                | []        | 1 | 0 || [1]
        [0]                | [1]       | 0 | 1 || [1]
    }
}

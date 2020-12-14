package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class RotateArrayTest extends Specification {
    def "should rotate array by k positions"(int[] nums, int k, int[] expected) {
        given:
        RotateArray rotateArray = new RotateArray()

        when:
        rotateArray.rotate(nums, k);

        then:
        Arrays.equals(nums, expected)

        where:
        nums                  | k || expected
        [1, 2, 3, 4, 5, 6, 7] | 3 || [5, 6, 7, 1, 2, 3, 4]
        [-1, -100, 3, 99]     | 2 || [3, 99, -1, -100]
        [-1]                  | 2 || [-1]
    }
}

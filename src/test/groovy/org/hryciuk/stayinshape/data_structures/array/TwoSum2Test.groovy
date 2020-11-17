package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class TwoSum2Test extends Specification {
    def "should find two sum in sorted array"(int[] input, int target, int[] expected) {
        given:
        TwoSum2 twoSum2 = new TwoSum2()

        when:
        int[] actual = twoSum2.twoSum(input, target)

        then:
        Arrays.equals(actual, expected)

        where:
        input          | target || expected
        [2, 7, 11, 15] | 9      || [1, 2]
        [2, 3, 4]      | 6      || [1, 3]
        [-1, 0]        | -1     || [1, 2]


    }
}

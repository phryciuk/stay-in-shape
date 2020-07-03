package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class TwoSumIIInputArrayIsSortedTest extends Specification {

    def "should return 2sum"(int[] input, int target, int[] expected) {
        given:
        TwoSumIIInputArrayIsSorted twoSumIIInputArrayIsSorted = new TwoSumIIInputArrayIsSorted()

        when:
        def actual = twoSumIIInputArrayIsSorted.twoSum(input, target)

        then:
        actual[0] == expected[0]
        actual[1] == expected[1]

        where:
        input                      | target | expected
        [2, 7, 11, 15]             | 9      | [1, 2]
        [2, 7, 11, 17, 24, 29, 50] | 18     | [2, 3]
        [-1, 0]                    | -1     | [1, 2]
    }
}

package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class NonDecreasingArrayTest extends Specification {
    def 'should determine if it is a nondecreasing array'(int[] input, boolean expected) {
        given:
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray()

        when:
        def actual = nonDecreasingArray.checkPossibility(input)

        then:
        actual == expected

        where:
        input         | expected
        [4, 2, 1]     | false
        [4, 2, 3]     | true
        [3, 4, 2, 3]  | false
        [4, 2, 4, 3]  | false
        [5, 2, 3, 4]  | true
        [6, 7, 1, 2]  | false
        [1, 2, 3, 1]  | true
        [-1, 4, 2, 3] | true
    }

}

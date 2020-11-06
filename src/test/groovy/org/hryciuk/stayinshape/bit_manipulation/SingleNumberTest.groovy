package org.hryciuk.stayinshape.bit_manipulation

import spock.lang.Specification
import spock.lang.Unroll

class SingleNumberTest extends Specification {
    @Unroll
    def "Should return the number which occurs only once"(int[] input, int expected) {
        given:
        SingleNumber singleNumber = new SingleNumber()

        when:
        int actual = singleNumber.singleNumber(input)

        then:
        actual == expected

        where:
        input           || expected
        [2, 2, 1]       || 1
        [4, 1, 2, 1, 2] || 4
        [1]             || 1
        [2, 2, 3, 3, 5] || 5
    }
}

package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class HowManyNumbersAreSmallerThanTheCurrentNumberTest extends Specification {

    def 'should return array of numbers smaller than current number'(int[] input, int[] expected) {
        given:
        HowManyNumbersAreSmallerThanTheCurrentNumber testing = new HowManyNumbersAreSmallerThanTheCurrentNumber();

        when:
        def actual = testing.smallerNumbersThanCurrentQuicker(input)

        then:
        actual == expected

        where:
        input           | expected
        [8, 1, 2, 2, 3] | [4, 0, 1, 1, 3]
    }
}

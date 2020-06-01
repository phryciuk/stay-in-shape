package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class FruitsIntoBasketsTest extends Specification {
    def "should determine the biggest number of fruits in the 2 baskets"(int[] input, int expected) {
        given:
        FruitsIntoBaskets fruits = new FruitsIntoBaskets()

        when:
        int actual = fruits.totalFruit(input)

        then:
        actual == expected

        where:
        input                             | expected
        [1, 2, 1]                         | 3
        [0, 1, 2, 2]                      | 3
        [1, 2, 3, 2, 2]                   | 4
        [3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4] | 5
        [1]                               | 1
        [1, 2]                            | 2
        [2, 2]                            | 2
    }
}

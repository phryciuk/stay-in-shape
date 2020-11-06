package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class TrappingRainWaterTest extends Specification {
    @Unroll
    def "should say how much water can be trapped"(int[] input, int expected) {
        given:
        TrappingRainWater trappingRainWater = new TrappingRainWater()

        when:
        int actual = trappingRainWater.trappingRainWater(input)

        then:
        actual == expected

        where:
        input                                | expected
        [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] | 6
        []                                   | 0
        [1]                                  | 0
        [1, 0]                               | 0
    }
}

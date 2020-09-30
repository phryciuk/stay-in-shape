package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class TrappingRainWaterTest extends Specification {
    def "should say how much water can be trapped"(int[] input, int expected) {
        given:
        TrappingRainWater trappingRainWater = new TrappingRainWater()

        when:
        int actual = trappingRainWater.trap(input)

        then:
        actual == expected

        where:
        input                                | expected
        [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] | 6
    }
}

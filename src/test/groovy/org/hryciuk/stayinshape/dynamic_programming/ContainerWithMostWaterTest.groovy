package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class ContainerWithMostWaterTest extends Specification {
    def "should return container with most water"(int[] height, int expected) {
        given:
        ContainerWithMostWater container = new ContainerWithMostWater()

        when:
        int actual = container.maxArea(height)

        then:
        actual == expected

        where:
        height                      || expected
        [1, 8, 6, 2, 5, 4, 8, 3, 7] || 49
        [1, 1]                      || 1
        [4, 3, 2, 1, 4]             || 16
        [1, 2, 1]                   || 2
    }
}

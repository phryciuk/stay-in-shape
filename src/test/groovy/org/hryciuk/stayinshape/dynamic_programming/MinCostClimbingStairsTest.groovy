package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class MinCostClimbingStairsTest extends Specification {
    def "should climb stairs"(int[] input, int expectedResult) {

        given:
        MinCostClimbingStairs climbingStairs = new MinCostClimbingStairs();

        when:
        int result = climbingStairs.minCostClimbingStairs(input);

        then:
        result == expectedResult;

        where:
        input                                                         | expectedResult
        [10, 15, 20]                                                  | 15
        [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]                          | 6
        [0, 0, 0, 0, 1, 3, 1, 321, 3, 1, 6, 4, 2, 5, 32, 2, 1, 1, 10] | 18

    }
}

package org.hryciuk.stayinshape.dynamic_programming


import spock.lang.Specification

class ClimbingStairsTest extends Specification {
    def "should climb stairs"(int input, int expectedResult) {

        given:
        ClimbingStairs climbingStairs = new ClimbingStairs();

        when:
        int result = climbingStairs.climbStairs(input);

        then:
        result == expectedResult;

        where:
        input | expectedResult
        1     | 1
        2     | 2
        3     | 3
        4     | 5
        5     | 8
    }
}

package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class HouseRobberTest extends Specification {
    def "should optimally rob houses"(int[] input, int expectedResult) {

        given:
        HouseRobber houseRobber = new HouseRobber();

        when:
        int result = houseRobber.rob(input);

        then:
        result == expectedResult;

        where:
        input                              | expectedResult
        [1, 2, 3, 1]                       | 4
        []                                 | 0
        [1]                                | 1
        [2, 3]                             | 3
        [2, 1, 1, 2]                       | 4
        [3, 1, 1, 4, 1, 1, 1, 1, 1, 1, 19] | 28
        [2, 7, 9, 3, 1]                    | 12
        [1, 1, 1, 1, 1]                    | 3
    }
}

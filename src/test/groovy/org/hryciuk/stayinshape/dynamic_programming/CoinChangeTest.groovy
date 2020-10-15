package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification
import spock.lang.Unroll

class CoinChangeTest extends Specification {
    @Unroll
    def "should change coins"(int[] coins, int amount, int expectedResult) {

        given:
        CoinChange coinChange = new CoinChange();

        when:
        int result = coinChange.coinChange(coins, amount);

        then:
        result == expectedResult;

        where:
        coins     | amount | expectedResult
        [1, 2, 5] | 11     | 3
        [1, 2, 5] | 11     | 3
        [3, 5]    | 8      | 2
        [2]       | 3      | -1
        [1]       | 0      | 0
        [1]       | 1      | 1
        [1]       | 2      | 2
    }

}

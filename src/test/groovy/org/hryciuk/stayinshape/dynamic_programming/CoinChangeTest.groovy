package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class CoinChangeTest extends Specification {
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
        [2]       | 3      | -1
    }

}

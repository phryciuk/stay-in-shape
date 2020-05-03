package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class BestTimeToBuyAndSellStock2Test extends Specification {

    def "should return max profit during some period"(int[] input, int expectedResult) {

        given:
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock2();
        int[] array = input

        when:
        int result = bestTimeToBuyAndSellStock.maxProfit(array);

        then:
        result == expectedResult;

        where:
        input                          | expectedResult
        [7, 1, 5, 3, 6, 4]             | 7
        [2, 4, 1]                      | 2
        [2, 4, 1, 0]                   | 2
        [2, 4, 1, 2]                   | 3
        [3, 2, 6, 5, 0, 3]             | 7
        [3, 2, 6, 5, 1, 2, 3, 4, 0, 3] | 10
    }
}

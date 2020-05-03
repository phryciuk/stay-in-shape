package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class BestTimeToBuyAndSellStockTest extends Specification {

    def "should return 5"(int[] input, int expectedResult) {

        given:
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] array = input

        when:
        int result = bestTimeToBuyAndSellStock.maxProfit(array);

        then:
        result == expectedResult;

        where:
        input              | expectedResult
        [7, 1, 5, 3, 6, 4] | 5
        [2, 4, 1]          | 2
        [2, 4, 1, 0]       | 2
        [3, 2, 6, 5, 0, 3] | 4
    }

}

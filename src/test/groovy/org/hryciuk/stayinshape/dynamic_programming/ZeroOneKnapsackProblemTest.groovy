package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class ZeroOneKnapsackProblemTest extends Specification {
    def "should return the items that build up to maximum profit"(int[] weight, int[] profit, int capacity, int expectedSum) {
        given:
        ZeroOneKnapsackProblem zeroOneKnapsackProblem = new ZeroOneKnapsackProblem()

        when:
        int actual = zeroOneKnapsackProblem.findMaximumProfitBottomUpSpaceOptimized(weight, profit, capacity)

        then:
//        result.size() == expected.size()
//        result.containsAll(expected)
//        expectedSum == countSum(result)
        expectedSum == actual

        where:
        weight          | profit             | capacity || expectedSum
        [1, 2, 3, 5]    | [1, 6, 10, 16]     | 7        || 22
        [5, 3, 4, 2]    | [60, 50, 70, 30]   | 5        || 80
        [10, 20, 30]    | [60, 100, 120]     | 50       || 220
        [1, 2, 5, 6, 7] | [1, 6, 18, 22, 28] | 11       || 40
        [2, 3, 1, 4]    | [4, 5, 3, 7]       | 5        || 10

    }

    int countSum(List<Integer> items, int[] profit) {
        int sum = 0
        for (Integer item : items) {
            sum += profit[item]
        }
        return sum
    }


//    expected
//    [1, 3]
//    [2, 4]
}

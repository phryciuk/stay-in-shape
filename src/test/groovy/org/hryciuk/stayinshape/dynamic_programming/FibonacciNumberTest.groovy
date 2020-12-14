package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class FibonacciNumberTest extends Specification {
    def "should return fibonacci number"(int input, int expected) {
        given:
        FibonacciNumber fibonacciNumber = new FibonacciNumber()

        when:
        int actual = fibonacciNumber.fibWithMemoization(input)

        then:
        actual == expected

        where:
        input | expected
        5     | 5
        1     | 1
        0     | 0
        2     | 1
        30    | 832040
        7     | 13
        3     | 2

    }
}

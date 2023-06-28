package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class CountPrimesTest extends Specification {
    def "should count primes"(int input, int expected) {
        given:
        CountPrimes countPrimes = new CountPrimes()

        when:
        int actual = countPrimes.countPrimes(input)

        then:
        actual == expected

        where:
        input | expected
        10    | 4
        13    | 5
        0     | 0
        1     | 0
        5     | 2
        100   | 25

    }
}

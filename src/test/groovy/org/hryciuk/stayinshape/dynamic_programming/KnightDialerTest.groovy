package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification
import spock.lang.Unroll

class KnightDialerTest extends Specification {

    @Unroll
    def "should be a knight dialer"(int input, int expected) {
        given:
        KnightDialer knightDialer = new KnightDialer()

        when:
        int actual = knightDialer.knightDialer(input)

        then:
        actual == expected

        where:
        input | expected
        0     | 0
        1     | 10
        2     | 20
        3     | 46
        4     | 104
        3131  | 136006598
    }
}

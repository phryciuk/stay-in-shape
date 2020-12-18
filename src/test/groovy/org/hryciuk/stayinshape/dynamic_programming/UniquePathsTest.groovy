package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class UniquePathsTest extends Specification {

    def "should tell how many ways there are to go from start to end"(int m, int n, int expected) {
        given:
        UniquePaths uniquePaths = new UniquePaths()

        when:
        int actual = uniquePaths.uniquePaths(m, n)

        then:
        actual == expected

        where:
        m  | n  || expected
        3  | 7  || 28
        0  | 7  || 0
        3  | 3  || 6
        1  | 3  || 1
        12 | 7  || 12376
        10 | 10 || 48620
        20 | 20 || 985525432
        15 | 15 || 40116600
        17 | 17 || 601080390

    }
}

package org.hryciuk.stayinshape.data_structures.stack

import spock.lang.Specification

class DailyTemperaturesTest extends Specification {
    def "should test daily temperatures"(int[] input, int[] expected) {
        given:
        DailyTemperatures dailyTemperatures = new DailyTemperatures()

        when:
        int[] actual = dailyTemperatures.dailyTemperatures(input)

        then:
        actual == expected

        where:
        input                            || expected
        [73, 74, 75, 71, 69, 72, 76, 73] || [1, 1, 4, 2, 1, 1, 0, 0]
        [30, 40, 50, 60]                 || [1, 1, 1, 0]
        [30, 60, 90]                     || [1, 1, 0]
    }
}

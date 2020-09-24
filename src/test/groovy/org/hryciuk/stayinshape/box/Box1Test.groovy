package org.hryciuk.stayinshape.box

import spock.lang.Specification
import spock.lang.Unroll

class Box1Test extends Specification {
    @Unroll
    def "should"(String input, int expected) {
        given:
        Box1 box1 = new Box1()

        when:
        def actual = box1.programmerStrings2(input)

        then:
        actual == expected

        where:
        input                          | expected
        "progxrammerrxproxgrammer"     | 2
        "xprogxrmaxemrppprmmograeiruu" | 2
        "programmerprogrammer"         | 0
    }
}

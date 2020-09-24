package org.hryciuk.stayinshape.box

import spock.lang.Specification

class Box4Test extends Specification {
    def "should"() {
        given:
        Box4 box4 = new Box4()

        when:
        def actual = box4.method()

        then:
        actual == expected

        where:
        input | expected
    }
}

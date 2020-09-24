package org.hryciuk.stayinshape.box

import spock.lang.Specification

class Box3Test extends Specification {

    def "should"() {
        given:
        Box3 box3 = new Box3()

        when:
        def actual = box3.method()

        then:
        actual == expected

        where:
        input | expected
    }

}

package org.hryciuk.stayinshape.box

import spock.lang.Specification

class Box3Test extends Specification {

    def "should"() {
        given:
        Box3 box3 = new Box3()

        when:
        def actual = box3.findAllPossibleNumbers()

        then:
        actual.containsAll([167618, 167616, 183494, 183492, 183818, 183434, 181834, 183816, 161672, 183438, 181838, 161676, 161618, 161616, 183834, 161818, 161816, 183838, 161834, 181672, 167272, 161838, 181676, 167276, 181618, 181616, 181818, 181816, 167672, 167294, 167292, 167676])

    }

}

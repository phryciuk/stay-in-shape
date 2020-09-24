package org.hryciuk.stayinshape.box

import spock.lang.Specification
import spock.lang.Unroll

class Box2Test extends Specification {
    @Unroll
    def "should"(String input, int k, String expected) {
        given:
        Box2 box2 = new Box2()

        when:
        def actual = box2.compressWord(input, k)

        then:
        actual == expected

        where:
        input      | k | expected
        "abbcccb"  | 3 | "a"
        "aba"      | 2 | "aba"
        "baac"     | 2 | "bc"
        "piooootr" | 4 | "pitr"
    }
}

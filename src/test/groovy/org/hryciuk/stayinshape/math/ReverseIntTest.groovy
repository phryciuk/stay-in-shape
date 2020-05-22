package org.hryciuk.stayinshape.math

import spock.lang.Specification

class ReverseIntTest extends Specification {

    def "should reverse a string"(int input, int expected) {

        given:
        ReverseInt reverseInt = new ReverseInt()

        when:
        int actual = reverseInt.reverse(input)

        then:
        actual == expected

        where:
        input      || expected
        1020       || 201
        1234       || 4321
        1000       || 0001
        1221       || 1221
        -1000      || -1
        -123       || -321
        120        || 21
        1534236469 || 0


    }
}

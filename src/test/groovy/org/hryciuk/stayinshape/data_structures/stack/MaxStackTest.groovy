package org.hryciuk.stayinshape.data_structures.stack

import spock.lang.Specification

class MaxStackTest extends Specification {
    def "should have max stack property"() {
        given:
        MaxStack maxStack = new MaxStack()

        when:
        maxStack.push(1)
        maxStack.push(2)
        maxStack.push(3)
        maxStack.push(4)
        maxStack.push(2)
        maxStack.push(2)
        maxStack.push(4)
        maxStack.push(1)
        maxStack.push(3)

        then:
        maxStack.peekMax() == 4
        maxStack.pop() == 3

    }
}

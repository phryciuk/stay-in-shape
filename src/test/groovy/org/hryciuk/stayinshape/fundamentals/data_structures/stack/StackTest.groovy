package org.hryciuk.stayinshape.fundamentals.data_structures.stack

import spock.lang.Specification

class StackTest extends Specification {

    def "should have a stack behavior"() {
        given:
        Stack stack = new Stack(100)

        when:
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        then:
        stack.pop() == 5
        stack.pop() == 4
        stack.pop() == 3

        when:
        stack.push(6);

        then:
        stack.pop() == 6
        stack.pop() == 2
        stack.pop() == 1

    }
}

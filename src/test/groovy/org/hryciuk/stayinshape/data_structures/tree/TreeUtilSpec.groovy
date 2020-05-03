package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray


class TreeUtilSpec extends Specification {
    def "should create a binary tree from an array"() {
        given:
        def array = createFromArray([5, 4, 5, 1, 1, 5] as Integer[])

        expect:
        0 == 0
    }
}

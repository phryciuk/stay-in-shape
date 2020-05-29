package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class SameTreeTest extends Specification {
    def "should decide whether trees are the same"(Integer[] firstTree, Integer[] secondTree, boolean expectedResult) {
        given:
        def firstOne = createFromArray(firstTree as Integer[])
        def secondOne = createFromArray(secondTree as Integer[])

        when:
        SameTree sameTree = new SameTree()
        boolean actual = sameTree.isSameTree(firstOne, secondOne);

        then:
        actual == expectedResult

        where:
        firstTree | secondTree   | expectedResult
        [1, 2, 3] | [1, 2, 3]    | true
        [1, 2]    | [1, null, 2] | false
        [1, 2, 1] | [1, 1, 2]    | false
    }
}

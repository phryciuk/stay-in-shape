package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class SumOfRootToLeafBinaryNumbersTest extends Specification {
    def "should sum root to leaf binary numbers"(Integer[] tree, int expectedResult) {
        given:
        def treeNode = createFromArray(tree as Integer[])

        when:
        SumOfRootToLeafBinaryNumbers sumOfRootToLeafBinaryNumbers = new SumOfRootToLeafBinaryNumbers();
        int actual = sumOfRootToLeafBinaryNumbers.sumRootToLeaf(treeNode);

        then:
        actual == expectedResult

        where:
        tree                  | expectedResult
        [1, 0, 1, 0, 1, 0, 1] | 22
        [1, 1]                | 3
    }
}

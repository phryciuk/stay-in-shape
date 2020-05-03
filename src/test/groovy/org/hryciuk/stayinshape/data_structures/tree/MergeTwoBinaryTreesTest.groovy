package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class MergeTwoBinaryTreesTest extends Specification {
    def "should merge two binary trees"(Integer[] firstTree, Integer[] secondTree, Integer[] expectedResult) {
        given:
        def firstOne = createFromArray(firstTree as Integer[])
        def secondOne = createFromArray(secondTree as Integer[])

        when:
        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode actual = mergeTwoBinaryTrees.mergeTrees(firstOne, secondOne);

        then:
        actual == createFromArray(expectedResult)

        where:
        firstTree    | secondTree                  | expectedResult
        [1, 3, 2, 5] | [2, 1, 3, null, 4, null, 7] | [3, 4, 5, 5, 4, null, 7]
    }
}

package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreePruningTest extends Specification {

    @Unroll
    def 'should prune binary tree'(Integer[] treeAsArr, Integer[] expected) {
        given:
        TreeNode tree = TreeUtil.createFromArray(treeAsArr)
        BinaryTreePruning binaryTreePruning = new BinaryTreePruning()

        when:
        TreeNode actual = binaryTreePruning.pruneTreeSimpler(tree)

        then:
        TreeUtil.createFromArray(expected).equals(actual)

        where:
        treeAsArr                                                                                                                  || expected
        [1, null, 0, 0, 1]                                                                                                          | [1, null, 0, null, 1]
        [1, 0, 1, 0, 0, 0, 1]                                                                                                       | [1, null, 1, null, 1]
        [1, 1, 0, 1, 1, 0, 1, 0]                                                                                                    | [1, 1, 0, 1, 1, null, 1]
        []                                                                                                                          | []
        [0, 0, 0, 0, 0, 0]                                                                                                          | []
        [1, 1, 1, 1, 1, 0, 0, 0, 1, null, 0, 1, 1, null, 1, null, null, null, null, null, null, null, null, null, null, null, null] | [1, 1, 1, 1, 1, 0, 0, null, 1, null, null, 1, 1, null, 1]
    }
}

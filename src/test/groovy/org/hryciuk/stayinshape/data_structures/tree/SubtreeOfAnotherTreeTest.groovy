package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

class SubtreeOfAnotherTreeTest extends Specification {
    def 'should determine whether the tree is a subtree of another tree'(Integer[] s, Integer[] t, boolean expected) {
        given:
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree()
        TreeNode sTree = TreeUtil.createFromArray(s)
        TreeNode tTree = TreeUtil.createFromArray(t)
        when:
        boolean actual = subtreeOfAnotherTree.isSubtree(sTree, tTree);

        then:
        actual == expected

        where:
        s                              | t         | expected
        [3, 4, 5, 1, 2]                | [4, 1, 2] | true
        [3, 4, 5, 1, 2, null, null, 0] | [4, 1, 2] | false
    }
}

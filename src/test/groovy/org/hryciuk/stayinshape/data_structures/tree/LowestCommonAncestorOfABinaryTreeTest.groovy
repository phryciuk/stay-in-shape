package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification
import spock.lang.Unroll

class LowestCommonAncestorOfABinaryTreeTest extends Specification {
    @Unroll
    def 'should return lowest common ancestor of a binary tree'(Integer[] tree, int p, int q, int expected) {
        given:
        TreeNode root = TreeUtil.createFromArray(tree)
        TreeNode pTree = TreeUtil.findSubtree(root, p)
        TreeNode qTree = TreeUtil.findSubtree(root, q)

        when:
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree()
        TreeNode actual = lowestCommonAncestorOfABinaryTree.lowestCommonAncestor2(root, pTree, qTree)
        def subtree = TreeUtil.findSubtree(root, expected)

        then:
        actual == subtree


        where:
        tree                                    | p | q | expected
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 7 | 4 | 2
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 0 | 8 | 1
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 5 | 1 | 3
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 3 | 1 | 3
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 2 | 0 | 3
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 8 | 6 | 3
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 2 | 6 | 5
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 4 | 6 | 5
        [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 7 | 2 | 2
    }
}

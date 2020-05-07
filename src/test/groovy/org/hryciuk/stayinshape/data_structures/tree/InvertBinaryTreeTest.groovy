package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class InvertBinaryTreeTest extends Specification {
    def "invert binary tree"(Integer[] tree, Integer[] expectedResult) {
        given:
        def treeNode = createFromArray(tree as Integer[])

        when:
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode actual = invertBinaryTree.invertTree(treeNode);

        then:
        actual == createFromArray(expectedResult)

        where:
        tree         | expectedResult
        [4, 2, 7, 1] | [4, 7, 2, null, null, null, 1]

    }
}

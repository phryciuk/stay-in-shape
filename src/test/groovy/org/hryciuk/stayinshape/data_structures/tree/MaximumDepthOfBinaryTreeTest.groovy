package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class MaximumDepthOfBinaryTreeTest extends Specification {
    def "maximum depth of binary tree"(Integer[] tree, int expectedResult) {
        given:
        def treeNode = createFromArray(tree as Integer[])

        when:
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        int actual = maximumDepthOfBinaryTree.maxDepth(treeNode);

        then:
        actual == expectedResult

        where:
        tree                          | expectedResult
        [3, 9, 20, null, null, 15, 7] | 3
    }
}

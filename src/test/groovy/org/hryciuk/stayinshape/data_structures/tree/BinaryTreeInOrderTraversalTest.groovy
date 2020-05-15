package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class BinaryTreeInOrderTraversalTest extends Specification {

    def "should traverse binary tree in order"(Integer[] tree, Integer[] expectedResult) {
        given:
        def treeNode = createFromArray(tree as Integer[])

        when:
        BinaryTreeInOrderTraversal inOrderTraversal = new BinaryTreeInOrderTraversal()
        List<Integer> actual = inOrderTraversal.inorderTraversal(treeNode)

        then:
        actual == expectedResult

        where:
        tree                          | expectedResult
        [1, null, 2, 3]               | [1, 3, 2]
        [3, 9, 20, null, null, 15, 7] | [9, 3, 15, 20, 7]
    }
}

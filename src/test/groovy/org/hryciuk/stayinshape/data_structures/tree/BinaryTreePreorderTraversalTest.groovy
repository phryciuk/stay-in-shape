package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class BinaryTreePreorderTraversalTest extends Specification {

    def "should traverse binary tree preorder"(Integer[] tree, Integer[] expectedResult) {
        given:
        def treeNode = createFromArray(tree as Integer[])

        when:
        BinaryTreePreorderTraversal preorderTraversal = new BinaryTreePreorderTraversal()
        List<Integer> actual = preorderTraversal.preorderTraversal(treeNode)

        then:
        actual == expectedResult

        where:
        tree                                       | expectedResult
        [1, null, 2, 3]                            | [1, 2, 3]
        [3, 9, 20, null, null, 15, 7]              | [3, 9, 20, 15, 7]
        [1, 2, 3, 6, 7, 4, 5, null, null, 8, null] | [1, 2, 6, 7, 8, 3, 4, 5]
    }
}




package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class BinaryTreePostorderTraversalTest extends Specification {
    def "should traverse binary tree post order"(Integer[] tree, Integer[] expectedResult) {
        given:
        def treeNode = createFromArray(tree as Integer[])

        when:
        BinaryTreePostorderTraversal postorderTraversal = new BinaryTreePostorderTraversal()
        List<Integer> actual = postorderTraversal.postorderTraversal(treeNode)

        then:
        actual == expectedResult

        where:
        tree                                                               | expectedResult
        [1, 3, 2, 4, 5, null, 8, null, null, null, 6, null, null, null, 7] | [4, 7, 6, 5, 3, 8, 2, 1]
        [1, null, 2, 3]                                                    | [3, 2, 1]
        []                                                                 | []
        [1]                                                                | [1]
    }
}

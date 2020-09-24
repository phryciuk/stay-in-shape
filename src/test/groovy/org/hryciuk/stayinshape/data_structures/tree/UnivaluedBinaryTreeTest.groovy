package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

class UnivaluedBinaryTreeTest extends Specification {
    def "should determine whether tree is univalued"(Integer[] input, boolean expectedResult) {
        given:
        TreeNode tree = TreeUtil.createFromArray(input)

        when:
        UnivaluedBinaryTree univaluedBinaryTree = new UnivaluedBinaryTree()
        boolean actual = univaluedBinaryTree.isUnivalTree2(tree)

        then:
        actual == expectedResult

        where:
        input                                                                                    | expectedResult
        [8, null, 8, 8, null, 9, 8]                                                              | false
        [1, 1, 1, 1, 1, null, 1]                                                                 | true
        [2, 2, 2, 5, 2]                                                                          | false
        [4, 4, 9, null, 4, 4, null, null, null, 4]                                               | false
        [65, 35, 65, 65, 65, null, 65, null, null, null, 65, null, null, 65, 65, null, null, 65] | false
    }
}

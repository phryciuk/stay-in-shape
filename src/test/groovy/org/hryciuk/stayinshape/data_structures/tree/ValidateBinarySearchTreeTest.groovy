package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification
import spock.lang.Unroll

class ValidateBinarySearchTreeTest extends Specification {

    @Unroll
    def "should validate whether the tree is a binary search tree"(Integer[] tree, boolean expected) {
        given:
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree()
        TreeNode root = TreeUtil.createFromArray(tree)

        when:
        boolean actual = validateBinarySearchTree.isValidBST(root)

        then:
        actual == expected

        where:
        tree                            | expected
        [2, 1, 3]                       | true
        [1, 1]                          | false
        [5, 1, 4, null, null, 3, 6]     | false
        [2147483647]                    | true
        [-2147483648, null, 2147483647] | true
    }
}

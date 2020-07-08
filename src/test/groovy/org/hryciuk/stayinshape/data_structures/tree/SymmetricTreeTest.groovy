package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

class SymmetricTreeTest extends Specification {

    def "should determine whether a tree is symmetric or not"(Integer[] tree, boolean expected) {
        given:
        TreeNode root = TreeUtil.createFromArray(tree)
        SymmetricTree symmetricTree = new SymmetricTree()

        when:
        boolean actual = symmetricTree.isSymmetricIteratively(root)

        then:
        actual == expected

        where:
        tree                        | expected
        [1, 2, 2, 3, 4, 4, 3]       | true
        [1, 2, 2, null, 3, null, 3] | false
        []                          | true
        [1]                         | true
        [1, 2]                      | false
    }
}

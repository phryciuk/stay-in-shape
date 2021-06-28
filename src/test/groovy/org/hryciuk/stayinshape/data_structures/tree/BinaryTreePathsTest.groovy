package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

class BinaryTreePathsTest extends Specification {
    def "should return correct binary tree paths"(Integer[] tree, List<String> expected) {
        given:
        TreeNode root = TreeUtil.createFromArray(tree)
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths()

        when:
        def actual = binaryTreePaths.binaryTreePaths(root)

        then:
        actual == expected

        where:
        tree                           | expected
        [1, 2, 3, null, 5, null, null] | ["1->2->5", "1->3"]
    }
}

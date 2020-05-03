package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

class RangeSumOfBstTest extends Specification {

    def "should return sum of values in range"(Integer[] tree, int left, int right, int expected) {
        given:
        RangeSumOfBst rangeSumOfBst = new RangeSumOfBst();
        TreeNode treeNode = TreeUtil.createFromArray(tree)

        when:
        int actual = rangeSumOfBst.rangeSumBST(treeNode, left, right);

        then:
        actual == expected

        where:
        tree                                   | left | right | expected
        [10, 5, 15, 3, 7, -1, 18] as Integer[] | 7    | 15    | 32
    }
}

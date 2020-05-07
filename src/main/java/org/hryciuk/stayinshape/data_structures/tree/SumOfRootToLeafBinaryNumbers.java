package org.hryciuk.stayinshape.data_structures.tree;

import java.util.LinkedList;

public class SumOfRootToLeafBinaryNumbers {

    private int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfsPreorder(root, new LinkedList<>());
        return result;
    }

    private void dfsPreorder(TreeNode node, LinkedList<Integer> tempList) {
        if (node == null) {
            result += binaryToInt(tempList);
        }
        tempList.add(node.val);
        if (node.left == null && node.right == null) {
            result += binaryToInt(tempList);
            return;
        }
        if (node.left != null) {
            dfsPreorder(node.left, tempList);
            tempList.remove(tempList.size() - 1);
        }
        if (node.right != null) {
            dfsPreorder(node.right, tempList);
            tempList.remove(tempList.size() - 1);
        }

    }

    private int binaryToInt(LinkedList<Integer> list) {
        if (list == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < list.size(); ++i) {
            Integer value = list.get(i);
            res = (res << 1) + value;
        }
        return res;
    }
}

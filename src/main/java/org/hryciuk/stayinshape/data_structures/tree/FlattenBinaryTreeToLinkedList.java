package org.hryciuk.stayinshape.data_structures.tree;

import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> list = dfs(root);
        for (int i = 0; i < list.size() - 1; ++i) {
            TreeNode current = list.get(i);
            current.left = null;
            current.right = list.get(i + 1);
        }
        if (!list.isEmpty()) {
            list.get(list.size() - 1).left = null;
            list.get(list.size() - 1).right = null;
        }
    }

    List<TreeNode> dfs(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        result.add(root);
        List<TreeNode> left = dfs(root.left);
        List<TreeNode> right = dfs(root.right);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}

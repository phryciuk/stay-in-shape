package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        // root
        result.add(root.val);
        // left
        List<Integer> leftSubtree = preorderTraversal(root.left);
        result.addAll(leftSubtree);
        // right
        List<Integer> rightSubtree = preorderTraversal(root.right);
        result.addAll(rightSubtree);
        return result;
    }
}

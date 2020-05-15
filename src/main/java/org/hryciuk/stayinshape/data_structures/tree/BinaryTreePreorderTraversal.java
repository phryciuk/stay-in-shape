package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    // iteratively
    public List<Integer> preorderTraversalIteratively(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            } else {
                TreeNode popped = stack.pop();
                current = popped.right;
            }
        }
        return result;
    }

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

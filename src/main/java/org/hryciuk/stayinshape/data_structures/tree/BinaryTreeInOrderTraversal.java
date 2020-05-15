package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {

    // Iterative
    public List<Integer> inorderTraversalIterative(TreeNode root) {
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
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                current = pop.right;
            }
        }
        return result;
    }

    // recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        List<Integer> leftSubtree = inorderTraversal(root.left);
        if (leftSubtree != null) {
            result.addAll(leftSubtree);
        }
        result.add(root.val);
        List<Integer> rightSubtree = inorderTraversal(root.right);
        if (rightSubtree != null) {
            result.addAll(rightSubtree);
        }
        return result;
    }
}

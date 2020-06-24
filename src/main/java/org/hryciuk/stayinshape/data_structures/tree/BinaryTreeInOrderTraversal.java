package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {

    // Iterative
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // initial preconditions
        if (root == null) {
            return result;
        }
        // we create new stack
        Stack<TreeNode> stack = new Stack<>();
        // set the current to root
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // push the current element to the stack, and set the next current to left subtree
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // if there are no children on the left left then we pop the element off of the stack,
                // print it and add the right subtree of that element on the stack
                TreeNode pop = stack.pop();
                result.add(pop.val);
                current = pop.right;
            }
        }
        return result;
    }

    // recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // first the left subtree
        List<Integer> leftSubtree = inorderTraversal(root.left);
        result.addAll(leftSubtree);
        // then the root
        result.add(root.val);
        // then the right subtree
        List<Integer> rightSubtree = inorderTraversal(root.right);
        result.addAll(rightSubtree);
        return result;
    }
}

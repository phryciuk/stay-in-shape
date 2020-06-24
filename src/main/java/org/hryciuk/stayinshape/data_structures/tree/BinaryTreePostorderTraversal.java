package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);

        TreeNode current = null;
        while (!stack.isEmpty()) {
            current = stack.peek();
            stack.pop();
            if (!stack.isEmpty() && stack.peek() == current) {
                if (current.right != null) {
                    stack.push(current.right);
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                    stack.push(current.left);
                }
            } else {
                result.add(current.val);
            }
        }
        return result;
    }
}

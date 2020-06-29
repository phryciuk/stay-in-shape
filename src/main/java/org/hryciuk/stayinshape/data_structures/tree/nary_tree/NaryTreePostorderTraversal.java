package org.hryciuk.stayinshape.data_structures.tree.nary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {

    // iterative
    public List<Integer> postorderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        Node current = null;
        while (!stack.isEmpty()) {
            current = stack.peek();
            stack.pop();
            if (!stack.isEmpty() && current == stack.peek()) {
                for (int i = current.children.size() - 1; i >= 0; --i) {
                    stack.push(current.children.get(i));
                    stack.push(current.children.get(i));
                }
            } else {
                result.add(current.val);
            }
        }
        return result;
    }

    // recursive
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.children != null && !root.children.isEmpty()) {
            for (int i = 0; i < root.children.size(); ++i) {
                List<Integer> subsolution = postorder(root.children.get(i));
                result.addAll(subsolution);
            }
        }
        result.add(root.val);
        return result;
    }
}

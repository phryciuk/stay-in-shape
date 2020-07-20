package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> subresult = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode current = q.poll();
                subresult.add(current.val);
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            result.add(subresult);
        }
        return result;
    }
}

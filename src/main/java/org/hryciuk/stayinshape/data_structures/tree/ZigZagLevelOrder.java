package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> subresult = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode current = q.poll();
                if (level % 2 == 0) {
                    subresult.addFirst(current.val);
                } else {
                    subresult.add(current.val);
                }
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            result.add(subresult);
            level++;
        }
        return result;
    }
}

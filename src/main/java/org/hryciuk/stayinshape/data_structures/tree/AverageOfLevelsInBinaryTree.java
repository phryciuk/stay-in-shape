package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int numberOfElementsInTheLevel = queue.size();
            double sum = 0.0;
            for (int i = 0; i < numberOfElementsInTheLevel; ++i) {
                TreeNode polled = queue.poll();
                sum += polled.val;
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }
            result.add(sum / numberOfElementsInTheLevel);
        }
        return result;
    }
}

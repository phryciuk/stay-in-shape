package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        // mutable holders
        List<Integer> prev = new ArrayList<>();
        int[] min = new int[]{Integer.MAX_VALUE};
        dfs(root, prev, min);
        return min[0];
    }

    void dfs(TreeNode root, List<Integer> prev, int[] min) {
        // inorder traversal
        if (root == null) {
            return;
        }
        dfs(root.left, prev, min);
        if (prev.isEmpty()) {
            // root
            prev.add(root.val);
        } else {
            min[0] = Math.min(min[0], root.val - prev.get(0));
            prev.set(0, root.val);
        }
        dfs(root.right, prev, min);
    }
}

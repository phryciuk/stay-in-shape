package org.hryciuk.stayinshape.data_structures.tree;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
 *
 * If there are no nodes with an even-valued grandparent, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is between 1 and 10^4.
 *     The value of nodes is between 1 and 100.
 */
public class SumOfNodesWithEvenValuedGrandparent {

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = height(root);
        // 0 - parent, 1 - grandparent
        TreeNode[] ancestors = new TreeNode[2];
        int[] sum = new int[1];
        if (height >= 2) {
            dfs(root, ancestors, sum);
            return sum[0];
        } else {
            return 0;
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    private void dfs(TreeNode root, TreeNode[] ancestors, int[] sum) {
        if (root == null) {
            return;
        }
        // grandparent has even value
        if (ancestors[1] != null && ancestors[1].val % 2 == 0) {
            sum[0] += root.val;
        }
        // creating new ancestors array
        TreeNode[] newAncestors = new TreeNode[2];
        newAncestors[0] = root;
        newAncestors[1] = ancestors[0];

        dfs(root.left, newAncestors, sum);
        dfs(root.right, newAncestors, sum);
    }
}

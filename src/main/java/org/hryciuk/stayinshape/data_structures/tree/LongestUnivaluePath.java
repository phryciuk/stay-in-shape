package org.hryciuk.stayinshape.data_structures.tree;

class LongestUnivaluePath {

  int max = 0;

  public int longestUnivaluePath(TreeNode root) {
    if (root == null || (root.right == null && root.left == null)) {
      return 0;
    }
    int left = longestUnivaluePath(root.left);
    int right = longestUnivaluePath(root.right);
    if (root.left != null && root.left.val == root.val) {
      left++;
    }
    if (root.right != null && root.right.val == root.val) {
      right++;
    }
    max = Math.max(max, right );
    return 0;
  }

}

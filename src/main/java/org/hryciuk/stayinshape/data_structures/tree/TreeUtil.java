package org.hryciuk.stayinshape.data_structures.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeUtil {

  static TreeNode createFromArray(Integer[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(array[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int count = 1;
    while (count < array.length && !queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        Integer val = array[count++];
        node.left = val != null ? new TreeNode(val) : null;
        queue.add(node.left);
        if (count < array.length) {
          Integer val1 = array[count++];
          node.right = val1 != null ? new TreeNode(val1) : null;
          queue.add(node.right);
        }
      }
    }
    return root;
  }

  static TreeNode findSubtree(TreeNode root, int p) {
    if (root == null){
      return null;
    }
    List<TreeNode> found = new LinkedList<>();
    dfs(root, p, found);
    return found.get(0);
  }

  static void dfs(TreeNode root, int p, List<TreeNode> found) {
    if (root == null) {
      return;
    }
    dfs(root.left, p, found);
    if (p == root.val) {
      found.add(root);
      return;
    }
    dfs(root.right, p, found);
  }


}

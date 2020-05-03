package org.hryciuk.stayinshape.data_structures.tree;

import java.util.LinkedList;
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
        node.left = new TreeNode(array[count++]);
        queue.add(node.left);
        if (count < array.length) {
          node.right = new TreeNode(array[count++]);
          queue.add(node.right);
        }
      }
    }
    return root;
  }


}

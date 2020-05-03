package org.hryciuk.stayinshape.data_structures.tree;

import java.util.Objects;

class TreeNode {

  Integer val;
  TreeNode left;
  TreeNode right;

  TreeNode(Integer val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TreeNode treeNode = (TreeNode) o;
    return Objects.equals(val, treeNode.val) &&
            Objects.equals(left, treeNode.left) &&
            Objects.equals(right, treeNode.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right);
  }
}

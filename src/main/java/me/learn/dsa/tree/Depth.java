package me.learn.dsa.tree;

public class Depth {
  public int maxDepth(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    int leftDepth = maxDepth(treeNode.left);
    int rightDepth = maxDepth(treeNode.right);
    return Math.max(leftDepth, rightDepth) + 1;

  }
}

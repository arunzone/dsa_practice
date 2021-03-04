package me.learn.dsa.tree;

public class TreeMerger {

  public TreeNode mergeTrees(TreeNode left, TreeNode right) {
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    left.value += right.value;
    left.left = mergeTrees(left.left, right.left);
    left.right = mergeTrees(left.right, right.right);
    return left;
  }
}

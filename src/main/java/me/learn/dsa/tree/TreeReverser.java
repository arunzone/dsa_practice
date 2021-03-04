package me.learn.dsa.tree;

public class TreeReverser {
  public TreeNode reverse(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;
    root.left = reverse(root.left);
    root.right = reverse(root.right);
    return root;
  }
}

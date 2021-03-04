package me.learn.dsa.tree;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class TreeNode {
  Integer value;
  TreeNode right;
  TreeNode left;

  public TreeNode(Integer value) {
    this.value = value;
  }

  public TreeNode(Integer value, TreeNode right, TreeNode left) {
    this.value = value;
    this.right = right;
    this.left = left;
  }

  public Integer getValue() {
    return value;
  }
}

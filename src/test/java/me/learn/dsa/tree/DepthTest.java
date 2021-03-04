package me.learn.dsa.tree;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DepthTest {
  @Test
  void shouldReturnMaxDepthForSingleNodeTree() {
    Depth depth = new Depth();

    int result = depth.maxDepth(new TreeNode(1));

    assertThat(result, is(1));

  }

  @Test
  void shouldReturnMaxDepthForLeftTreeNode() {
    Depth depth = new Depth();

    int result = depth.maxDepth(new TreeNode(1, null, new TreeNode(1)));

    assertThat(result, is(2));
  }

  @Test
  void shouldReturnMaxDepthForRightTreeNode() {
    Depth depth = new Depth();

    int result = depth.maxDepth(new TreeNode(1, new TreeNode(1), null));

    assertThat(result, is(2));
  }

  @Test
  void shouldReturnMaxDepthForRightAndLeftTreeNode() {
    Depth depth = new Depth();
    TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
    TreeNode root = new TreeNode(1, new TreeNode(9), right);
    int result = depth.maxDepth(root);

    assertThat(result, is(3));
  }

}
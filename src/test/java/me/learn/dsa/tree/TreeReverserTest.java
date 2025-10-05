package me.learn.dsa.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

class TreeReverserTest {

  @Test
  void shouldReturnReversedTree() {
    TreeReverser reverser = new TreeReverser();
    TreeNode right = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    TreeNode left = new TreeNode(7, new TreeNode(6), new TreeNode(9));
    TreeNode root = new TreeNode(4, right, left);
    TreeNode reversed = reverser.reverse(root);

    assertThat(
        reversed,
        is(
            new TreeNode(
                4,
                new TreeNode(7, new TreeNode(9), new TreeNode(6)),
                new TreeNode(2, new TreeNode(3), new TreeNode(1)))));
  }
}

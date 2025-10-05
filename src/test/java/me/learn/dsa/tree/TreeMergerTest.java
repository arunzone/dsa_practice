package me.learn.dsa.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

public class TreeMergerTest {

  @Test
  void shouldMergeSingleRootTrees() {
    TreeMerger treeMerger = new TreeMerger();
    TreeNode rightTree = new TreeNode(1);
    TreeNode leftTree = new TreeNode(1);
    TreeNode mergedNode = treeMerger.mergeTrees(leftTree, rightTree);

    assertThat(mergedNode, is(new TreeNode(2)));
  }

  @Test
  void shouldMergeOneLevelTrees() {
    TreeMerger treeMerger = new TreeMerger();
    TreeNode rightTree = new TreeNode(1);
    TreeNode leftTree = new TreeNode(1, new TreeNode(2), null);
    TreeNode mergedNode = treeMerger.mergeTrees(leftTree, rightTree);

    assertThat(mergedNode, is(new TreeNode(2, new TreeNode(2), null)));
  }
}

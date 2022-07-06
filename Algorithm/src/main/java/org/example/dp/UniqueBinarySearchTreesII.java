package org.example.dp;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class UniqueBinarySearchTreesII {

  public List<TreeNode> generateTrees(int start, int end) {
    List<TreeNode> allTrees = new LinkedList<>();
    if (start > end) {
      allTrees.add(null);
      return allTrees;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftTrees = generateTrees(start, i - 1);
      List<TreeNode> rightTrees = generateTrees(i + 1, end);
      for (TreeNode left : leftTrees) {
        for (TreeNode right : rightTrees) {
          TreeNode node = new TreeNode(i, left, right);
          allTrees.add(node);
        }
      }
    }
    return allTrees;
  }


  public List<TreeNode> generateTrees(int n) {
    return generateTrees(1, n);
  }

}

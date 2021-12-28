package org.example.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}


public class S1315 {
  private int ans = 0;

  private int getSumOfChildren(TreeNode node) {
    int res = 0;
    if(node != null) {
      res += node.left == null ? 0 : node.left.val;
      res += node.right == null ? 0 : node.right.val;
    }
    return res;
  }

  private int getSumOfGrandChildren(TreeNode node) {
    return getSumOfChildren(node.left) + getSumOfChildren(node.right);
  }

  public int sumEvenGrandparent(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode node = null;
    if (root != null) {
      q.add(root);
    }
    while (!q.isEmpty()) {
      node = q.poll();
      if (node.val % 2 == 0) {
        ans += getSumOfGrandChildren(node);
      }
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
    }
    return ans;
  }
}

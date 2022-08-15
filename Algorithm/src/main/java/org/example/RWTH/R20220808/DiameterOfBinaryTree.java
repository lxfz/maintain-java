package org.example.RWTH.R20220808;

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

class Solution {

  public int ans = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    solve(root);
    return ans;
  }

  public int solve(TreeNode node) {
    if (node == null) return 0;
    int leftGain = solve(node.left);
    int rightGain = solve(node.right);
    ans = Math.max(ans, leftGain + rightGain + 1);
    return Math.max(leftGain, rightGain) + 1;
  }

}

public class DiameterOfBinaryTree {

}

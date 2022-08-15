package org.example.RWTH.R20220725;

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

public class BinaryTreeMaximumPathSum {
  private int ans = Integer.MIN_VALUE;

  public void solve(TreeNode root) {
    if (root == null) return;
    maxPathSum(root.left);
    maxPathSum(root.right);
    int singleSideVal = root.val;

    if (root.left != null) {
      this.ans = Math.max(root.left.val + root.val, this.ans);
      singleSideVal = Math.max(singleSideVal, root.left.val + root.val);
    }

    if (root.right != null) {
      this.ans = Math.max(root.right.val + root.val, this.ans);
      singleSideVal = Math.max(singleSideVal, root.right.val + root.val);
    }

    if (root.left != null && root.right != null) {
      this.ans = Math.max(root.left.val + root.right.val + root.val, this.ans);
    }

    this.ans = Math.max(root.val, this.ans);

    root.val = singleSideVal;
  }

  public int maxPathSum(TreeNode root) {
    solve(root);
    return this.ans;
  }
}

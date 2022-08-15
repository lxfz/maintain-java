package org.example.dp.tree;


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

  private int solve(TreeNode node) {
    if (node == null) return 0;

    int left = solve(node.left);
    int right = solve(node.right);

    int newVal = Math.max(node.val, node.val + left);
    newVal = Math.max(newVal, node.val + right);

    if(newVal > this.ans) this.ans = newVal;
    if(node.val + left + right > ans) ans = node.val + left + right;

    return newVal;
  }


  public int maxPathSum(TreeNode root) {
    solve(root);
    return this.ans;
  }


  public static void main(String[] args) {

  }


}

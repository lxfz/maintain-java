package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S0337 {

  public class TreeNode {
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

  private Map<TreeNode, Integer> m = new HashMap<>();

  public int rob(TreeNode root) {
    if(root == null) return 0;
    if(m.containsKey(root)) return m.get(root);
    int ans = root.val;
    if(root.left != null) {
      ans += rob(root.left.left) + rob(root.left.right);
    }
    if(root.right != null) {
      ans += rob(root.right.left) + rob(root.right.right);
    }
    ans = Math.max(ans, rob(root.left) + rob(root.right));
    m.put(root, ans);
    return ans;
  }
  

}

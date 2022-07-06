package org.example.RWTH.R20220614_DFS;

import java.util.ArrayList;
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

/**
 * 257. Binary Tree Paths
 */

public class BinaryTreePaths {


  class Solution {
    List<String> ans = new ArrayList<>();

    public void dfs(TreeNode node, String currentPath) {
      /**
       * 当进入dfs的时候，当前节点已经处理好了
       */
      if (node.left == null && node.right == null) {
        ans.add(currentPath);
      }

      if (node.left !=  null) {
        dfs(node.left, currentPath + "->" + node.left.val);
      }

      if (node.right != null) {
        dfs(node.right, currentPath + "->" + node.right.val);
      }
    }

    public List<String> binaryTreePaths(TreeNode root) {
      String currentPath = Integer.toString(root.val);
      dfs(root, currentPath);
      return ans;
    }
  }
}












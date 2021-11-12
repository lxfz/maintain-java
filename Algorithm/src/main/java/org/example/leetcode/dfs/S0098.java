package org.example.leetcode.dfs;

public class S0098 {

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


    // public boolean isValidBST(TreeNode left, TreeNode right, int rootValue) {
    //   if(left == null && right == null) return true;
    //   boolean result = true;

    //   // left
    //   if(left != null) {
    //     if(left.val >= rootValue) {
    //       return false;
    //     } else {
    //       result = result && isValidBST(left.left, left.right, left.val);
    //     }
    //   }

    //   // right
    //   if(right != null) {
    //     if(right.val <= rootValue) {
    //       return false;
    //     } else {
    //       result = result && isValidBST(right.left, right.right, right.val);
    //     }
    //   }
    //   return result;
    // }


    public boolean isValidBST(TreeNode root, int[] min_max) {
      min_max[0] = root.val; // min
      min_max[1] = root.val; // max
      if(root.left == null && root.right == null){
        return true;
      }
      boolean result = true;
      int[] left_min_max = new int[2];
      int[] right_min_max = new int[2];

      if(root.left != null) {
        result = result && isValidBST(root.left, left_min_max);
        if(left_min_max[1] >= root.val) {
          result = false;
        }
        min_max[0] = Math.min(min_max[0], left_min_max[0]);
        min_max[1] = Math.max(min_max[1], left_min_max[1]);
      }

      if(root.right != null) {
        result = result && isValidBST(root.right, right_min_max);
        if(right_min_max[0] <= root.val) {
          result = false;
        }
        min_max[0] = Math.min(min_max[0], right_min_max[0]);
        min_max[1] = Math.max(min_max[1], right_min_max[1]);
      }
      return result;
    }

    public boolean isValidBST(TreeNode root) {
      if(root == null) return true;
      return isValidBST(root, new int[2]);
    }
  
    public static void main(String[] args) {
      S0098 solution = new S0098();
      TreeNode rl = solution.new TreeNode(6);
      TreeNode rr = solution.new TreeNode(20);
      TreeNode r = solution.new TreeNode(15, rl, rr);
      TreeNode l = solution.new TreeNode(5);
      TreeNode root =   solution.new TreeNode(10, l, r);
      System.out.println(solution.isValidBST(root));
    }
}

package org.example.dp.linear;

/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
    System.out.println(uniqueBinarySearchTrees.numTrees(1));
  }
}

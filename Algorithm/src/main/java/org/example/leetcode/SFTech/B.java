package org.example.leetcode.SFTech;

public class B {
  public int minRemainingSpace(int[] N, int V) {
    int len = N.length;
    int[][] dp = new int[len][V+1];
    for (int j = 0; j <= V; j++) {
      dp[0][j] = j >= N[0] ? N[0] : 0;
    }
    for (int i = 1; i < len; i++) {
      for (int j = 0; j <= V; j++) {
        if (j >= N[i]) {
          dp[i][j] = Math.max(dp[i - 1][j - N[i]] + N[i], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return V - dp[len - 1][V];
  }

  public static void main(String[] args) {
    B solution = new B();
    int[] N = {8, 1, 12, 7, 9, 7};
    int V = 11;
    System.out.println(solution.minRemainingSpace(N, V));


  }
}

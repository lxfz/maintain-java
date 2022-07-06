package org.example.dp;

public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int ans = 0;
    for (int i = 0; i < m; i++) {
      dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
    }
    for (int j = 0; j < n; j++) {
      dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '1') {
          dp[i][j] = 1;
          int k = dp[i - 1][j - 1]; // 以dp[i-1][j-1]为右下角构成的最大正方形
          for (int h = 1; h <= k; h++) {
            if (matrix[i][j - h] == '1' && matrix[i - h][j] == '1') {
              dp[i][j]++;
            } else {
              break;
            }
          }
        } else {
          dp[i][j] = 0;
        }
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans;
  }


}

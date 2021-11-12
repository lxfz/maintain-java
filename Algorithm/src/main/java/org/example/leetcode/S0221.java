package org.example.leetcode;

public class S0221 {
  public int maximalSquare(char[][] matrix) {
    int nr = matrix.length;
    int nc = matrix[0].length;
    int[][] dp = new int[nr+1][nc+1];
    int[][] V = new int[nr+1][nc+1];
    int[][] H = new int[nr+1][nc+1];
    int ans = 0;
    for(int i=1; i<=nr; i++) {
      for(int j=1; j<=nc; j++) {
        if(matrix[i-1][j-1] == '1') {
          V[i][j] = V[i-1][j] + 1;
          H[i][j] = H[i][j-1] + 1;
          dp[i][j] = Math.min(dp[i-1][j-1], Math.min(V[i-1][j], H[i][j-1])) + 1;
          dp[i][j] = Math.max(dp[i][j], Math.min(dp[i][j-1], V[i][j]));
          dp[i][j] = Math.max(dp[i][j], Math.min(dp[i-1][j], H[i][j]));
          ans = Math.max(dp[i][j], ans);
        }
      }
    }
    return ans * ans;
  }
}

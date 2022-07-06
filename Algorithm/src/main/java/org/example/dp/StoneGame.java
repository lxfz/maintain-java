package org.example.dp;

public class StoneGame {
  public boolean stoneGame(int[] piles) {
    int N = piles.length;
    int[][] dp = new int[N][N];
    int[][] sum = new int[N][N];
    for (int i = 0; i < N; i++) {
      dp[i][i] = piles[i];
      sum[i][i] = piles[i];
    }

    for (int L = 2; L <= N; L++) {
      for (int i = 0; i < N; i++) {
        int j = i + L - 1;
        if (j >= N) {
          break;
        }
        sum[i][j] = piles[i] + sum[i + 1][j];
        dp[i][j] = Math.max(sum[i + 1][j] - dp[i + 1][j] + piles[i],
            sum[i][j - 1] - dp[i][j - 1] + piles[j]);
      }
    }
    return 2 * dp[0][N - 1] >= sum[0][N - 1];
  }
}

package org.example.dp.linear;

import java.util.Arrays;

public class MinimumDifficultyofaJobSchedule {

  public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (n < d) return -1;
    int[][] dp = new int[n + 1][d + 1];

    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
      max = Integer.max(max, jobDifficulty[i - 1]);
      dp[i][1] = max;
    }

    for (int j = 2; j <= d; j++) {
      for (int i = j; i <= n; i++) {
        max = jobDifficulty[i - 1];
        for (int k = i - 1; k >= j - 1; k--) {
          max = Math.max(max, jobDifficulty[k]);
          dp[i][j] = Math.min(dp[k][j - 1] + max, dp[i][j]);
        }
        System.out.println(dp[i][j]);
      }
    }
    return dp[n][d];
  }

  public static void main(String[] args) {
    int[] a = {7, 1, 7, 1, 7, 1};
    int d = 3;
    MinimumDifficultyofaJobSchedule minimumDifficultyofaJobSchedule = new MinimumDifficultyofaJobSchedule();
    System.out.println( minimumDifficultyofaJobSchedule.minDifficulty(a, d));
  }
}

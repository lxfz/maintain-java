package org.example.dp;

public class PredictTheWinner {
  public boolean PredictTheWinner(int[] nums) {
    int N = nums.length;
    int[][] dp = new int[N][N];
    int[][] sum = new int[N][N];
    for (int i = 0; i < N; i++) {
      dp[i][i] = nums[i];
      sum[i][i] = nums[i];
    }

    for (int L = 2; L <= N; L++) {
      for (int i = 0; i < N; i++) {
        int j = i + L - 1;
        if (j >= N) {
          break;
        }
        sum[i][j] = nums[i] + sum[i + 1][j];
        dp[i][j] = Math.max(sum[i + 1][j] - dp[i + 1][j] + nums[i],
            sum[i][j - 1] - dp[i][j - 1] + nums[j]);
      }
    }
    return 2 * dp[0][N - 1] >= sum[0][N - 1];
  }

  public static void main(String[] args) {
    PredictTheWinner solution = new PredictTheWinner();
    int[] nums = {1,5,233,7};
    System.out.println(solution.PredictTheWinner(nums));
  }
}

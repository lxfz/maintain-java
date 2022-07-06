package org.example.dp.linear;

public class BestTimetoBuyandSellStockwithCooldown {
  public int maxProfit(int[] prices) {
    int N = prices.length;
    int[][] dp = new int[N][N];
    for (int L = 2; L <= N; L++) {
      for (int i = 0; i < N; i++) {
        int j = i + L - 1;
        if (j >= N) break;
        dp[i][j] = Math.max(dp[i][j], prices[j] - prices[i]);
        dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
        dp[i][j] = Math.max(dp[i][j], dp[i+1][j]);
        for (int k = i; k <= j - 1; k++) {
          if(k+2 < N) {
            dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 2][j]);
          }
        }
      }
    }
    return dp[0][N - 1];
  }

  public static void main(String[] args) {
    BestTimetoBuyandSellStockwithCooldown solution = new BestTimetoBuyandSellStockwithCooldown();
    int[] prices = {1,4,2};
    System.out.println(solution.maxProfit(prices));
  }
}

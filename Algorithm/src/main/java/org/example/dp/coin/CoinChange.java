package org.example.dp.coin;

import java.util.Arrays;

/**
 * 不是最优的
 * f[i] = min( f[i-coins[j]] + 1)
 */
public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[coins.length][amount + 1];
    for (int i = 0; i < coins.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    for (int k = 0; k * coins[0] <= amount; k++) {
      dp[0][k * coins[0]] = k;
    }
    for (int i = 1; i < coins.length; i++) {
      for (int j = 0; j <= amount; j++) {
        for (int k = 0; k * coins[i] <= j; k++) {
          if (dp[i - 1][j - k * coins[i]] < Integer.MAX_VALUE) {
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i]] + k);
          }
        }
      }
    }
    return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
  }

  public static void main(String[] args) {
    int[] coins = {2, 5, 10, 1};
    int amount = 27;
    CoinChange coinChange = new CoinChange();
    System.out.println(coinChange.coinChange(coins, amount));
  }
}

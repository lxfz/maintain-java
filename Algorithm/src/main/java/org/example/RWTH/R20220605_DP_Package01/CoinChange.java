package org.example.RWTH.R20220605_DP_Package01;

import java.util.Arrays;

/**
 * 为什么做过了也不会？
 */
public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i >= coins[j]) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    if (dp[amount] <= amount) {
      return dp[amount];
    }
    return -1;
  }

  public static void main(String[] args) {

  }
}

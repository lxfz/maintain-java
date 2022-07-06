package org.example.dp.PrefixSum;

import java.util.Arrays;

public class JumpGameII {
  public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i < nums.length; i++) {
      for (int k = i - 1; k >= 0; k--) {
        if (nums[k] >= i - k) {
          dp[i] = Math.min(dp[i], dp[k] + 1);
        }
      }
    }
    return dp[nums.length - 1];
  }
}

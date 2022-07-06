package org.example.dp;

public class MaximumProductSubarray {
  /**
   * 使用区间dp来解，内存超限
   */
  public int maxProductA(int[] nums) {
    int ans = Integer.MIN_VALUE;
    int[][] dp = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
      dp[i][i] = nums[i];
      ans = Math.max(ans, dp[i][i]);
    }
    for (int L = 2; L <= nums.length; L++) {
      for (int i = 0; i < nums.length; i++) {
        int j = i + L - 1;
        if (j >= nums.length) break;
        dp[i][j] = dp[i][j - 1] * nums[j];
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans;
  }

  public int maxProduct(int[] nums) {
    int[] dpMax = new int[nums.length];
    int[] dpMin = new int[nums.length];
    int ans = Integer.MIN_VALUE;
    dpMax[0] = dpMin[0] = nums[0];
    ans = Math.max(ans, dpMax[0]);
    for (int i = 1; i < nums.length; i++) {
      dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
      dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
      ans = Math.max(ans, dpMax[i]);
    }
    return ans;
  }
}

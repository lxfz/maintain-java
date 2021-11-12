package org.example.leetcode;

public class S0198 {
  public int rob(int[] nums) {
    int n = nums.length;
    int[] dp = new int [n];
    dp[0] = nums[0];
    if(n>1) dp[1] = Math.max(nums[1], nums[0]);
    for(int i=2; i<n; i++) {
      dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
    }
    return dp[n];
  }
}

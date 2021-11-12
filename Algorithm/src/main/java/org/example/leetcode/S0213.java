package org.example.leetcode;

class S0213 {

  public int rob(int[] nums, int lo, int hi) {
    if (lo == hi) return nums[lo];
    int n = nums.length;
    int[] dp = new int[n];
    dp[lo] = nums[lo];
    dp[lo+1] = Math.max(nums[lo], nums[lo+1]);
    for(int i=lo+2; i<=hi; i++) {
      dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
    }
    return dp[hi];
  }

  public int rob(int[] nums) {
    if(nums.length == 1) return nums[0];
    int a = rob(nums, 0, nums.length-2);
    int b = rob(nums, 1, nums.length-1);
    return Math.max(a, b);
  }
}
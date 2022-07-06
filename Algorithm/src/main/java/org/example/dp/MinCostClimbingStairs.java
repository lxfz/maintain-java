package org.example.dp;


/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/
 * 746. Min Cost Climbing Stairs
 */
public class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length+1];
    for(int i=2; i<=cost.length; i++) {
      dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2]+cost[i-2]);
    }
    return dp[cost.length];
  }

  public static void main(String[] args) {

  }
}

package org.example.RWTH.R20220605_DP_Package01;

public class PartitionEqualSubsetSum {

  /**
   * 416. Partition Equal Subset Sum
   * TODO 查看bitset的解法
   */
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int x : nums) {
      sum += x;
    }
    if (sum % 2 != 0) {
      return false;
    }
    int[][] dp = new int[nums.length][sum / 2 + 1];
    for (int j = 0; j <= sum / 2; j++) {
      dp[0][j] = j >= nums[0] ? nums[0] : 0;
    }
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j <= sum / 2; j++) {
        if (j >= nums[i]) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[nums.length - 1][sum / 2] == sum / 2;
  }

  public static void main(String[] args) {
    PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
    int[] nums = {1, 5, 10, 6};
    System.out.println(partitionEqualSubsetSum.canPartition(nums));
  }
}

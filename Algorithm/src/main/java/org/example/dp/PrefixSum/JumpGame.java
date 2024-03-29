package org.example.dp.PrefixSum;

import java.util.Arrays;

public class JumpGame {
  public boolean canJump(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[0] = true;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && j + nums[j] >= i) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[nums.length - 1];
  }

  public static void main(String[] args) {
    JumpGame jumpGame = new JumpGame();
    int[] nums = {0};
    System.out.println(jumpGame.canJump(nums));
  }
}

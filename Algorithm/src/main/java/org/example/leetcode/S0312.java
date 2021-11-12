package org.example.leetcode;

import java.util.Arrays;

public class S0312 {
  public int maxCoins(int[] nums) {
    if (nums.length == 0) return 0;
    int left = 0, right = 0;
    int coin = 0;
    int j = 0;
    int[][] f = new int[nums.length][nums.length];

    for (int len = 1; len <= nums.length; len++) {
      for (int i = 0; i < nums.length; i++) {
        j = i + len - 1;
        if (j < nums.length) {
          left = i - 1 >= 0 ? nums[i - 1] : 1;
          right = j + 1 == nums.length ? 1 : nums[j + 1];

          for (int k = i; k <=j; k++) {
            coin = left * nums[k] * right;
            if (k - 1 >= i)
              coin += f[i][k - 1];
            if (k + 1 <= j)
              coin += f[k + 1][j];
            f[i][j] = Math.max(f[i][j], coin);
          }
        }
      }
    }
    return f[0][nums.length-1];
  }

  public static void main(String[] args) {
    int[] nums = {3,1,5,8};
    System.out.println(new S0312().maxCoins(nums));
  }
}

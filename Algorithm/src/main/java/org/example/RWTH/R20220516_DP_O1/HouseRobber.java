package org.example.RWTH.R20220516_DP_O1;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
  public int rob(int[] nums) {
    int rob = nums[0];
    int no_rob = 0;
    int tmp_rob = 0;
    for(int i=1; i<nums.length; i++) {
      tmp_rob = nums[i] + no_rob;
      no_rob = Math.max(rob, no_rob);
      rob = tmp_rob;
    }
    return Math.max(no_rob, rob);
  }

  public static void main(String[] args) {

  }
}

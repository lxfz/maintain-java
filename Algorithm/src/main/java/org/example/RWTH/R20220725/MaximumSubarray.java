package org.example.RWTH.R20220725;

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int ans = nums[0];
    int currentSum = Math.max(nums[0], 0);
    for (int i = 1; i < nums.length; i++) {
      currentSum += nums[i];
      ans = Math.max(ans, currentSum);
      if (currentSum < 0) {
        currentSum = 0;
      }
    }
    return ans;
  }
}

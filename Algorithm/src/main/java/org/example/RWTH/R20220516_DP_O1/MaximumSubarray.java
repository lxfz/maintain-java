package org.example.RWTH.R20220516_DP_O1;

/**
 * 以 nums[i] 结尾的最大值只依赖于以 nums[i-1] 结尾的最大值，
 * 所以可以使用O(1)的空间复杂度
 */

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {

    int maxSoFar = nums[0], maxEndingHere = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxEndingHere = Math.max(nums[i] + maxEndingHere, nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }

  public static void main(String[] args) {
    int[] nums = {5,4,-1,7,8};
    MaximumSubarray maximumSubarray = new MaximumSubarray();
    System.out.println(maximumSubarray.maxSubArray(nums));
  }
}

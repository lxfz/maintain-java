package org.example.leetcode;

import java.util.Arrays;

public class S1509 {

  public int minDifference(int[] nums) {
    if(nums.length <= 4) return 0;
    int[] res = new int[4];
    Arrays.sort(nums);
    res[0] = nums[nums.length-1] - nums[3];
    res[1] = nums[nums.length-2] - nums[2];
    res[2] = nums[nums.length-3] - nums[1];
    res[3] = nums[nums.length-4] - nums[0];
    return Math.min(res[0], Math.min(res[1], Math.min(res[2], res[3])));
  }
  
  public static void main(String[] args) {
    int[] nums = {82,81,95,75,20};
    System.out.println(new S1509().minDifference(nums));
  }

}
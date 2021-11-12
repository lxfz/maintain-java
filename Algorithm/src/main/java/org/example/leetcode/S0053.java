package org.example.leetcode;

public class S0053 {

  public int maxSubArray(int[] nums) {
    int ans = nums[0];
    int[] c = new int[nums.length+1];
    c[0] = 0;
    for(int i=1; i<=nums.length; i++) {
      if(c[i-1] > 0) c[i] = nums[i-1] + c[i-1];
      else c[i] = nums[i-1];
      ans = Math.max(ans, c[i]);
    }
    return ans;
  }


  public static void main(String[] args) {
    int[] nums = new int[]{-2};
    System.out.println(new S0053().maxSubArray(nums));
  }
  
}
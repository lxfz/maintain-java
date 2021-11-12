package org.example.leetcode;

public class S0152 {

  public int maxProduct(int[] nums) {
    if(nums.length == 0) return 0;
    int tempMax = nums[0];
    int product = 0;
    for(int i=1; i<nums.length; i++) {
      product = 1;
      for(int j=i; j>=0; j--) {
        product *= nums[j];
        tempMax = Math.max(tempMax, product);
      }
    }
    return tempMax;
  }

  public static void main(String[] args) {
    int[] nums = {-3, -4};
    System.out.println(new S0152().maxProduct(nums));
  }
  
}

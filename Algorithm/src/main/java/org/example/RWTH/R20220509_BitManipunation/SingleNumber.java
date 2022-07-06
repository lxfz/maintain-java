package org.example.RWTH.R20220509_BitManipunation;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    int res = 0;
    for(int i=0; i<nums.length; i++) {
      res ^= nums[i];
    }
    return res;
  }

  public static void main(String[] args) {

  }
}

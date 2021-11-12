package org.example.leetcode;

public class S1086 {

  public int specialArray(int[] nums) {
    int f[] = new int[1001];
    int pre = 0;
    for(int i=0; i<nums.length; i++) {
      f[nums[i]]++;
    }
    for(int i=0; i<f.length; i++) {
      if(nums.length - pre == i) {
        return i;
      } else {
        pre += f[i];
      }
    }
    return -1;   
  }

  public static void main(String[] args) {
    
  }
  
}

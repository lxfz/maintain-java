package org.example.leetcode;

public class S0055 {

  public boolean canJump_01(int[] nums) {
    boolean[] pos = new boolean[nums.length];
    pos[0] = true;
    if(nums.length == 1) return true; // 考虑边界条件
    for(int i = 0; i<nums.length; i++) {
      if (pos[i] == false) continue;
      for(int j=1; j<=nums[i]; j++) {
        pos[j+i] = true;
        if (j+i == nums.length - 1) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean canJump(int[] nums) {
    int farestIdx = 0;
    for(int i=0; i<nums.length; i++) {
      if(i <= farestIdx && i+nums[i] >= farestIdx){
        farestIdx = i+nums[i];
      }
    }
    return farestIdx >= nums.length - 1;
  }


}

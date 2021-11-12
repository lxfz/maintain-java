package org.example.leetcode;

public class S0376 {
  public int wiggleMaxLength(int[] nums) {
    int n = nums.length;
    int[][] ans = new int[n][2];
    ans[0][0] = 1;
    ans[0][1] = 1;
    int res = 1;
    for(int i=1; i<n; i++) {
      for(int j=i-1; j>=0; j--) {
        if(nums[i] > nums[j]) {
          ans[i][1] = Math.max(ans[i][1], ans[j][0] + 1);
        } else if(nums[i] < nums[j]) {
          ans[i][0] = Math.max(ans[i][0], ans[j][1] + 1);
        }
      }
      res = Math.max(Math.max(res, ans[i][0]), ans[i][1]);
    }    
    return res;
  }
}

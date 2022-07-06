package org.example.dp;

public class GetMaximumInGeneratedArray {
  public int getMaximumGenerated(int n) {
    int[] nums = new int[n+1];
    if(n==0) return 0;
    if(n==1) return 1;
    nums[0] = 0;
    nums[1] = 1;
    int ans = 1;
    for(int i=2; i<=n; i++) {
      if (i % 2 == 0) {
        nums[i] = nums[i/2];
      } else {
        nums[i] = nums[i/2] + nums[i/2+1];
      }
      ans = Math.max(ans, nums[i]);
      System.out.println(ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    GetMaximumInGeneratedArray getMaximumInGeneratedArray = new GetMaximumInGeneratedArray();
    System.out.println(getMaximumInGeneratedArray.getMaximumGenerated(4));
  }
}

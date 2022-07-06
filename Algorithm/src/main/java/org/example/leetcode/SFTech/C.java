package org.example.leetcode.SFTech;

public class C {
  public int findMaxCI(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    int ans = 1;
    int tempAns = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        tempAns++;
      } else {
        ans = Math.max(ans, tempAns);
        tempAns = 1;
      }
    }
    ans = Math.max(ans, tempAns);
    return ans;
  }

  public static void main(String[] args) {
    C solution = new C();
    int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57};
    System.out.println(solution.findMaxCI(nums));
  }
}

package org.example.RWTH.R20220605_DP_Package01;

/**
 * 474. Ones and Zeroes
 */
public class OnesAndZeroes {

  public int res = 0;
  public int target = -1;
  public int[] nums = null;

  public void search(int pos, int sign, int currentSum) {
    currentSum += nums[pos] * sign;
    if (pos == this.nums.length-1){
      if (currentSum == this.target){
        res++;
      }
      return;
    }
    search(pos+1, 1, currentSum);
    search(pos+1, -1, currentSum);
  }

  public int findTargetSumWays(int[] nums, int target) {
    this.nums = nums;
    this.target = target;
    search(0, 1, 0);
    search(0, -1, 0);
    return res;
  }

  public static void main(String[] args) {
    OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
    int[] nums = {1};
    int target = 1;
    onesAndZeroes.findTargetSumWays(nums, target);
    System.out.println(onesAndZeroes.res);
  }
}

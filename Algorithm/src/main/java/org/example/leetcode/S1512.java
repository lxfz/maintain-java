package org.example.leetcode;

public class S1512 {

  public int numIdenticalPairs(int[] nums) {
    int[] f = new int[101];
    int res = 0;
    for(int e:nums) f[e]++;
    for(int i=0; i<f.length; i++) {
      res += f[i] * (f[i] -1) /2;
    }   
    return res;
  }


  public static void main(String[] args) {
    int[] nums = {1,2,3};
    System.out.println(new S1512().numIdenticalPairs(nums));
  }
}
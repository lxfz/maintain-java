package org.example.leetcode.BiweeklyContest37;

import java.util.Arrays;

public class Solution1 {

  public double trimMean(int[] arr) {
    double ans = 0.0;
    int remove = arr.length / 20;
    Arrays.sort(arr);
    for(int i=remove; i<arr.length - remove; i++) {
      ans += arr[i];
    }
    ans = ans / (arr.length - 2*remove);
    return ans;
  }

  public static void main(String[] args) {
    
  }
  
}

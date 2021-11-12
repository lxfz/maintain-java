package org.example.leetcode;

import java.util.Arrays;

public class S1508 {

  public int rangeSum(int[] nums, int n, int left, int right) {
    int[] a = new int[n * (n+1)/2];
    int[][] f = new int[n+1][n+1];
    int k =0, res = 0;
    int m = 1000000007;
    for(int i=0; i<n; i++) f[i+1][i+1] = nums[i];

    for(int i=1; i<=n; i++)
      for(int j=i; j<=n; j++) {
        f[i][j] = (f[i-1][j-1] + f[j][j]) % m;
        a[k++] = f[i][j];
      }
    Arrays.sort(a);
    for(int i=left-1; i<right; i++) res = (res + a[i]) % m;
    return res;
  }


  public static void main(String[] args) {
    int[] nums = {1,2,3,4};

    int n = 4, left = 1, right = 10;
    System.out.println(new S1508().rangeSum(nums, n, left, right));
  }
  
}
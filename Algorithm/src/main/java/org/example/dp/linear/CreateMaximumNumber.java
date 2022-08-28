package org.example.dp.linear;

import java.math.BigInteger;

public class CreateMaximumNumber {

  public int[] convert(long n, int k) {
    int[] ans = new int[k];
    for(int i=k-1; i>=0; i--) {
      ans[i] = (int) (n % 10);
      n /= 10;
    }
    return ans;
  }

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;
    long[][][] dp = new long[m+1][n+1][k+1];
    dp[1][0][1] = nums1[0];
    dp[0][1][1] = nums2[0];

    for(int i=1; i<=m; i++) {
      for(int h=1; h<=k; h++) {
        dp[i][0][h] = Math.max(dp[i-1][0][h-1] * 10 + nums1[i-1], dp[i-1][0][h]);
      }
    }

    for(int i=1; i<=n; i++) {
      for(int h=1; h<=k; h++) {
        dp[0][i][h] = Math.max(dp[0][i-1][h-1] * 10 + nums2[i-1], dp[0][i-1][h]);
      }
    }


    for(int i=1; i<=m; i++) {
      for(int j=1; j<=n; j++) {
        for(int h=1; h<=i+j && h<=k; h++) {
          dp[i][j][h] = Math.max(dp[i][j][h], dp[i][j-1][h]);
          dp[i][j][h] = Math.max(dp[i][j][h], dp[i-1][j][h]);
          dp[i][j][h] = Math.max(dp[i][j][h], dp[i-1][j-1][h]);

          dp[i][j][h] = Math.max(dp[i][j][h], dp[i-1][j][h-1] * 10 + nums1[i-1]);
          dp[i][j][h] = Math.max(dp[i][j][h], dp[i][j-1][h-1] * 10 + nums2[j-1]);
          dp[i][j][h] = Math.max(dp[i][j][h], dp[i-1][j-1][h-1] * 10 + Math.max(nums1[i-1], nums2[j-1]));
        }
      }
    }
    return convert(dp[m][n][k], k);
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{2,5,6,4,4,0};
    int[] nums2 = new int[]{7,3,8,0,6,5,7,6,2};
    int k = 15;
    CreateMaximumNumber solution = new CreateMaximumNumber();
    for(int x : solution.maxNumber(nums1, nums2, k)) {
      System.out.printf("%d ", x);
    }
  }

}

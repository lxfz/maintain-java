package org.example.leetcode;

public class IntegerReplacement {

  public int integerReplacement(int n) {
    long[] dp = new long[n+1];
    for(int i=2; i<=n; i++) {
      if(i % 2 == 0) {
        dp[i] = dp[i/2] + 1;
      } else {
        dp[i] = Math.min(dp[(i+1)/2], dp[(i-1)/2]) + 2;
      }
      System.out.printf("%10d  %5d\n", i, dp[i]);
    }
    return (int) dp[n];
  }


  public static void main(String[] args) {
    IntegerReplacement integerReplacement = new IntegerReplacement();
    System.out.println(integerReplacement.integerReplacement(100000000));
    System.out.println(Integer.MAX_VALUE);
  }
}

package org.example.leetcode;

public class S0338 {
  public int[] countBits(int n) {
    int[] ans = new int[n+1];
    if(n == 0) return ans;
    ans[0] = 0;
    ans[1] = 1;
    for(int i=2; i<=n; i++) {
      if(i % 2 == 1) ans[i] = ans[i-1] + 1;
      else ans[i] = ans[i/2];
    }
    return ans;

  }
}

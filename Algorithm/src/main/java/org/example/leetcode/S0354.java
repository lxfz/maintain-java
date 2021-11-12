package org.example.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class S0354 {
  // 改成二分查找
  public int maxEnvelopes(int[][] envelopes) {
    int n = envelopes.length;
    int[] f = new int[n];
    int ans = 0;
    Arrays.sort(envelopes, new Comparator<int[]>(){
      @Override
      public int compare(int[] a, int[] b) {
        if(a[0] == b[0]) {
          return Integer.compare(a[1], b[1]);
        } else{
          return Integer.compare(a[0], b[0]);
        }
      }
    });
    f[0] = 1;
    for(int i=1; i<n; i++) {
      f[i] = 1;
      for(int j=0; j<i; j++) {
        if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
          f[i] = Math.max(f[i], f[j]+1);
        }
        ans = Math.max(f[i], ans);
      }
    }
    return ans;
  }
  
}

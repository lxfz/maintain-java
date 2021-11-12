package org.example.leetcode.BiweeklyContest37;

public class Solution3 {

  // draw j Line Segments before the (i+1)th number

  public int numberOfSets(int n, int k) {
    int mod = 1_000_000_007;
    int[][] f = new int[n][k+1]; // e.g. dp
    for(int i=0; i<n; i++) f[i][0] = 1;
/**
 * 
 * TLE ):
 *  
    for(int i=1; i<n; i++) {
      for(int j=1; j<=k; j++) {
        f[i][j] = (f[i][j] + f[i-1][j]) % mod;
        for(int h=i-1; h>0; h--) {
          if(f[h][j-1] == 0) break;
          f[i][j] = (f[i][j] + f[h][j-1]) % mod;
        }
      }
    }
 */

    // Accept :)

    for(int j=1; j<=k; j++) {
      int t = f[0][j-1];
      for(int i=1; i<n; i++) {
        f[i][j] = (f[i][j] + f[i-1][j]) % mod;
        f[i][j] = (f[i][j] + t) % mod;
        t = (t + f[i][j-1]) % mod;
      }
    }
    return f[n-1][k];    
  }

  public static void main(String[] args) {
    int n = 921;
    int k = 753;
    System.out.println(new Solution3().numberOfSets(n, k));
  }
  
}

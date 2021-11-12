package org.example.leetcode;

public class S0096 {


  public int numTrees(int n) {
    int[][] f = new int[n+1][n+1];
    for(int i=1; i<=n; i++) f[i][i] = 1;
    for(int len=2; len <= n; len++) {
      for(int i=1; i<=n; i++) {
        int j = i + len - 1;
        if(j > n) break;
        for(int k=i; k<=j; k++) {
          int temp = 1;
          temp *= k-1 >= i ? f[i][k-1] : 1;
          temp *= k+1 <= j ? f[k+1][j] : 1;
          f[i][j] += temp;
        }
      }
    }
    return f[1][n];
  }

  public static void main(String[] args) {
    
  }
  
}

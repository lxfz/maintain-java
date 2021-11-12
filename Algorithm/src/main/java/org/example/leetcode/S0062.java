package org.example.leetcode;

public class S0062 {

  public int uniquePaths(int m, int n) {
    int[][] f = new int[m+2][n+2];
    f[m][n] = 1;

    for(int i=m; i>0; i--) 
      for(int j=n; j>0; j--) 
        f[i][j] += f[i][j+1] + f[i+1][j];
    return f[1][1];
  }

  public static void main(String[] args) {
    int m = 2, n = 3;
    System.out.println(new S0062().uniquePaths(m, n));
  }
  
}
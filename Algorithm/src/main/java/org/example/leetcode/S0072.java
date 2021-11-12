package org.example.leetcode;

public class S0072 {

  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int f[][] = new int[m+2][n+2];

    for(int i=1; i<=n; i++) f[m+1][i] = n-i+1;
    for(int i=1; i<=m; i++) f[i][n+1] = m-i+1;
    f[m+1][n+1] = 0;
    for(int i=m; i>0; i--)
      for(int j=n; j>0; j--) {
        f[i][j] = Math.min(f[i+1][j] + 1, f[i][j+1] + 1);
        if(word1.charAt(i-1) == word2.charAt(j-1)) {
          f[i][j] = Math.min(f[i][j], f[i+1][j+1]);
        } else {
          f[i][j] = Math.min(f[i][j], f[i+1][j+1] + 1);
        }
      }
    return f[1][1];
  }

  public static void main(String[] args) {
    String word1 = "", word2 = "a";
    System.out.println(new S0072().minDistance(word1, word2));
  }
}
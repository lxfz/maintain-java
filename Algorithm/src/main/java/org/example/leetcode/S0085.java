package org.example.leetcode;

public class S0085 {

  public int maximalRectangle(char[][] matrix) {
    // n x m
    int ans = 0;
    int n = matrix.length;
    int m = matrix[0].length;
    if(n == 0 || m == 0) return 0;
    int[][] g = new int[m][m];
    for(int d=0; d<n; d++) {
      for(int len = 1; len <=m; len++) {
        for(int i=0; i<m; i++) {
          int j = i + len - 1;
          if(j>=m) continue;
          boolean flagCan = true;
          for(int k=i; k<=j; k++){
            if(matrix[d][k] == '0'){
              flagCan = false;
              break;
            } 
          }
          if(flagCan) {
            g[i][j] += len;
            ans = Math.max(ans, g[i][j]);
          } else {
            g[i][j] = 0;
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    System.out.println(new S0085().maximalRectangle(matrix));
  }
}

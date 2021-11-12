package org.example.leetcode;

public class S0063 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    int f[][] = new int[m+1][n+1];
    f[1][1] = 1;
    for(int i=1; i<=m; i++) 
      for(int j=1; j<=n; j++) {
        if(obstacleGrid[i-1][j-1] == 1) f[i][j] = 0;
        else f[i][j] += f[i-1][j] + f[i][j-1];
      }
    return f[m][n];
  }

  public static void main(String[] args) {
    
    int[][] obstacleGrid = {
      {0,0,0},
      {0,1,0},
      {0,0,0}
    };

    System.out.println(new S0063().uniquePathsWithObstacles(obstacleGrid));

  }
  
}
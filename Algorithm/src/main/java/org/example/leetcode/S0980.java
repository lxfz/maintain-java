package org.example.leetcode;

public class S0980 {

  public int count = 0;
  public int numOfSpace = 0;

  public void dfs(int[][] grid, int startX, int startY, int space) {
    if(grid[startX][startY] == 2){
      if(numOfSpace == space) count++;
      return;
    }

    if(grid[startX][startY] == -1) return;

    int t = grid[startX][startY];
    grid[startX][startY] = -1;
    space++;

    if(startX - 1 >=0) dfs(grid, startX-1, startY, space);
    if(startY + 1 <grid[0].length) dfs(grid, startX, startY+1, space);
    if(startX + 1 < grid.length) dfs(grid, startX+1, startY, space);
    if(startY-1>=0) dfs(grid, startX, startY-1, space);
    
    grid[startX][startY] = t ;
    space--;
  }

  public int uniquePathsIII(int[][] grid) {
    int startX=0, startY=0;
    int space = 0;
    for(int i=0; i<grid.length; i++) 
      for(int j=0; j<grid[0].length; j++) {
        if(grid[i][j] == 1) {
          startX = i;
          startY = j;
          numOfSpace++;
        }
        if(grid[i][j] == 0) numOfSpace++;
      }
        
    dfs(grid, startX, startY, space);
    return count;
  }


  public static void main(String[] args) {
    int[][] grid = {{0,1},{2,0}};
    System.out.println(new S0980().uniquePathsIII(grid)); 
  }
  
}
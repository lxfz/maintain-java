package org.example.RWTH.R20220614_DFS;

public class MaxAreaOfIsland {

  public int ans = 0;
  public int currentAns = 0;

  public void dfs(int[][] grid, int[][] mask, int i, int j) {
    // out of range
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return;
    }
    // water or visited
    if (grid[i][j] == 0 || mask[i][j] == -1) {
      return;
    }

    mask[i][j] = -1;
    this.currentAns++;
    dfs(grid, mask, i - 1, j);
    dfs(grid, mask, i + 1, j);
    dfs(grid, mask, i, j - 1);
    dfs(grid, mask, i, j + 1);
  }

  public int maxAreaOfIsland(int[][] grid) {
    int[][] mask = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        this.currentAns = 0;
        dfs(grid, mask, i, j);
        this.ans = Math.max(this.ans, this.currentAns);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
    int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
  }
}

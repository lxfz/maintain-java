package org.example.leetcode.WeeklyContest0210;

public class S1615 {
  public int maximalNetworkRank(int n, int[][] roads) {
    if(roads.length == 0) return 0;
    int ans = 0;
    int[][] g = new int[n][n];
    int[] degree = new int[n];
    for(int i=0; i<roads.length; i++) {
      g[roads[i][0]][roads[i][1]] = 1;
      g[roads[i][1]][roads[i][0]] = 1;
      degree[roads[i][0]]++;
      degree[roads[i][1]]++;
    }
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        if(i != j) {
          ans = Math.max(ans, degree[i] + degree[j] - g[i][j]);
        }
      }
    }  
    return ans;
  }

  public static void main(String[] args) {
    
  }
}

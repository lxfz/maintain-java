package org.example.leetcode.SFTech;

public class E {

  private int[][] distance = null;
  private boolean[] visited = null;

  public void dfs(int node) {
    visited[node] = true;
    for (int i = 0; i < distance.length; i++) {
      if (!visited[i] && distance[node][i] <= 2) {
        dfs(i);
      }
    }
  }

  public boolean isCompliance(int[][] distance, int n) {
    this.distance = distance;
    this.visited = new boolean[distance.length];
    int count = 0;
    for (int i = 0; i < distance.length; i++) {
      if (!visited[i]) {
        count++;
        dfs(i);
      }
    }
    return count <= n;
  }

  public static void main(String[] args) {
    E solution = new E();

  }
}

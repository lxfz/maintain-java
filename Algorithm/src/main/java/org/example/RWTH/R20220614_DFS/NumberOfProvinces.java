package org.example.RWTH.R20220614_DFS;

public class NumberOfProvinces {

  public void dfs(int[][] isConnected, boolean[] visited, int i) {
    visited[i] = true;
    for(int j=0; j<isConnected.length; j++) {
      if(isConnected[i][j] == 1 && !visited[j]) {
        dfs(isConnected, visited, j);
      }
    }
  }


  public int findCircleNum(int[][] isConnected) {
    boolean[] visited = new boolean[isConnected.length];
    int numComponent = 0;
    for(int i=0; i<isConnected.length; i++) {
      if(!visited[i]) {
        numComponent++;
        dfs(isConnected, visited, i);
      }
    }
    return numComponent;
  }

  public static void main(String[] args) {
    NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
    System.out.println(numberOfProvinces.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
  }
}

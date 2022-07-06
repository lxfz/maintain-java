package org.example.leetcode.SFTech;

import java.util.Arrays;

public class A {
  int N = 100;

  public boolean dfs(int node, int[][] G, boolean[] visited) {
    if (visited[node]) {
      return true;
    }
    visited[node] = true;
    boolean res = false;
    for (int i = 0; i < N; i++) {
      if (G[node][i] == 1) {
        res = res || dfs(i, G, visited);
      }
    }
    visited[node] = false;
    return res;
  }

  public boolean hasCycle(String graph) {
    String[] connections = graph.split(",");
    int[][] G = new int[100][100];
    for (String s : connections) {
      String[] nodes = s.split("->");
      int a = Integer.parseInt(nodes[0]);
      int b = Integer.parseInt(nodes[1]);
      G[a][b] = 1;
    }
    boolean[] visited = new boolean[100];
    boolean res = false;
    for (int i = 0; i < N; i++) {
      res = dfs(i, G, visited);
      if (res) {
        return true;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    A solution = new A();
//    String s = "1->4,2->5,3->6,3->7,4->8,5->8,5->9,6->9,6->11,7->11,8->12,9->12,9->13,10->6,10->13,10->14,11->10,11->14";
//    String s = "1->4,2->5,3->6,3->7,4->8,5->8,5->9,6->9,6->11,7->11,8->12,9->12,9->13,10->6,10->13,10->14,11->10,11->14";
    String s = "1->4,2->5,3->6,3->7,4->8,5->8,5->9,6->9,6->11,7->11,8->12,9->12,9->13,10->13,10->14,11->10,11->14";
    System.out.println(solution.hasCycle(s));
  }
}

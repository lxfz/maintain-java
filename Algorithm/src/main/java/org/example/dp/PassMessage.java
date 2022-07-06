package org.example.dp;

import java.util.LinkedList;
import java.util.Queue;

/***
 * https://leetcode.cn/problems/chuan-di-xin-xi/
 * LCP 07. 传递信息
 */
public class PassMessage {
  int ans = 0;

  public void dfs(int[][] g, int currentNode, int currentLevel, int k) {
    if (currentLevel == k) {
      if (currentNode == g.length - 1) ans++;
      return;
    }
    for (int i = 0; i < g.length; i++) {
      if (g[currentNode][i] == 1) {
        dfs(g, i, currentLevel + 1, k);
      }
    }
  }

  public int numWays(int n, int[][] relation, int k) {
    int[][] g = new int[n][n];
    for (int i = 0; i < relation.length; i++) {
      g[relation[i][0]][relation[i][1]] = 1;
    }
    dfs(g, 0, 0, k);
    return ans;
  }

  public static void main(String[] args) {

  }
}

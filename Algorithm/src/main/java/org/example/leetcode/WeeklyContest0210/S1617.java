package org.example.leetcode.WeeklyContest0210;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1617 {

  int[][] g;
  int[][] distance;
  int numNode;

  public int getBit(int a, int b) {
    return (a >> b) & 1;
  }

  public void distance(int s) {
    int t;
    boolean[] visited = new boolean[numNode+1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    visited[s] = true;
    distance[s][s] = 0;
    while(!queue.isEmpty()) {
      t = queue.poll();
      for(int i=1; i<=numNode; i++) {
        if(!visited[i] && g[t][i] == 1) {
          distance[s][i] = distance[s][t] + 1;
          queue.add(i);
          visited[i] = true;
        }
      }
    }
  }

  public boolean checkConnected(int sub) {
    boolean[] visited = new boolean[numNode + 1];
    int[][] g_sub = new int[numNode+1][numNode+1];
    int beginNode = 0;
    Arrays.fill(visited, true);
    // build sub graph
    for(int i=1; i<=numNode; i++) {
      if(getBit(sub, i-1) == 1) {
        visited[i] = false;
        beginNode = i;
        for(int j=1; j<=numNode; j++) {
          if(getBit(sub, j-1)==1) {
            g_sub[i][j] = g[i][j];
            g_sub[j][i] = g[j][i];
          } 
        }
      }
    }

    // check if connected
    Queue<Integer> queue = new LinkedList<>();
    queue.add(beginNode);
    visited[beginNode] = true;
    while(!queue.isEmpty()) {
      int tempNode = queue.poll();
      for(int i=1; i<=numNode; i++) {
        if(!visited[i] && g_sub[tempNode][i] == 1) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
    for(int i=1; i<=numNode; i++) {
      if(!visited[i]) return false;
    }
    return true;
  }

  public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
    int[] d = new int[n-1];
    numNode = n;
    g = new int[n+1][n+1];
    distance = new int[n+1][n+1];
    int maxDofSub = 0;
    for(int i=0; i<edges.length; i++) {
      g[edges[i][0]][edges[i][1]] = 1;
      g[edges[i][1]][edges[i][0]] = 1;
    }
    for(int i=1; i<=n; i++) distance(i);

    int all = (1 << n) - 1;

    for(int sub=0; sub<=all ; sub++) {
      // System.out.println(Integer.toBinaryString(sub));
      if(checkConnected(sub) == false) continue;
      maxDofSub = 0;
      for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
          if(i != j && getBit(sub, i-1) == 1 && getBit(sub, j-1) == 1) {
            maxDofSub = Math.max(maxDofSub, distance[i][j]);
          }
        }
      }
      if(maxDofSub != 0) {
        // System.out.println(maxDofSub + "   " + Integer.toBinaryString(sub) + "\n\n");
        d[maxDofSub-1]++;
      }
    }
    return d;
  }
  public static void main(String[] args) {
    int n = 2;
    int[][] edges = {{1,2}};
    int[] d = new S1617().countSubgraphsForEachDiameter(n, edges);
    for(int i=1; i<n; i++) {
      System.out.print(d[i] + " ");
    }
  }
}

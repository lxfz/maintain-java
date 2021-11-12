package org.example.leetcode;

public class S1584 {

  int[][] g;
  int[] d;
  boolean[] collected;

  public int findMinDisPoint() {
    int minDis = Integer.MAX_VALUE;
    int minPoint = -1;
    for(int k=0; k<g.length; k++) {
      if( !collected[k] && d[k] < minDis ) {
        minDis = d[k];
        minPoint = k;
      }
    }
    return minPoint;
  }

  public int minCostConnectPoints(int[][] points) {
    int res = 0;
    int tempDis = 0;
    // build the graph
    g = new int[points.length][points.length];
    for(int i=0; i<points.length; i++) {
      g[i][i] = Integer.MAX_VALUE;
      for(int j=i+1; j<points.length; j++) {
        tempDis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1]-points[j][1]);
        g[i][j] = tempDis;
        g[j][i] = tempDis;
      }
    }
    // minimum spanning tree
    collected = new boolean[points.length];
    d = new int[points.length];
    int v = 0;
    collected[v] = true;
    for(int k=0; k<points.length; k++) d[k] = g[v][k];
    while(true) {
      v = findMinDisPoint();
      if(v == -1) break;
      collected[v] = true;
      res += d[v];
      for(int k=0; k<points.length; k++) {
        if(!collected[k] && g[v][k] < d[k]) d[k] = g[v][k];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
    System.out.println(new S1584().minCostConnectPoints(points));
  }
}

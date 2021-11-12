package org.example.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

public class S1514 {

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    double[] prob = new double[n];
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Double>[] mapa = new Map[n];
    int firstElem;
    double tempProb;

    for(int i=0; i<n; i++)
      mapa[i] = new HashMap<>();

    for(int i=0; i<edges.length; i++) {
      mapa[edges[i][0]].put(edges[i][1], succProb[i]);
      mapa[edges[i][1]].put(edges[i][0], succProb[i]);
    }

    for(int i=0; i<n; i++)
      prob[i] = 0;
    prob[start] = 1;
    queue.add(start);
    while(!queue.isEmpty()) {
      firstElem = queue.poll();
      for(int i : mapa[firstElem].keySet()){
      // for(int i=0; i<n; i++) {
        tempProb = mapa[firstElem].getOrDefault(i, -1.0);
        if(firstElem != i && tempProb * prob[firstElem] > prob[i]){
          prob[i] = tempProb * prob[firstElem];
          queue.add(i);
        }
      }
    }
    return prob[end];
  }

  double findProb(int a, int b, int[][] edges, double[] succProb) {
    for(int i=0; i<edges.length; i++) {
      if((edges[i][0] == a && edges[i][1] == b) || (edges[i][1] == a && edges[i][0] == b))
        return succProb[i];
    }
    return -1.0;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] edges = {{0,1},{1,2},{0,2}};
    double[] succProb = {0.5,0.5,0.2};
    int start = 0, end = 2;
    System.out.println(new S1514().maxProbability(n, edges, succProb, start, end));
  
  }
}
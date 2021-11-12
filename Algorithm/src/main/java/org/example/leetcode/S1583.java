package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S1583 {

  int sn;
  int[][] sprefrences;
  Map<Integer, Integer> pairMap = new HashMap<>();

  // if a prefer c over b
  public boolean check(int a, int b, int c) {
    for (int i = 0; i < sprefrences[a].length; i++) {
      if (sprefrences[a][i] == b)
        return false;
      else if (sprefrences[a][i] == c)
        return true;
    }
    return false;
  }

  public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
    int count = 0;
    sn = n;
    sprefrences = preferences;

    for (int i = 0; i < pairs.length; i++) {
      pairMap.put(pairs[i][0], pairs[i][1]);
      pairMap.put(pairs[i][1], pairs[i][0]);
    }
    for (int x = 0; x < n; x++) {
      int y = pairMap.get(x);
      for (int u = 0; u < preferences[x].length; u++) {
        if (preferences[x][u] == y)
          break;
        if (check(preferences[x][u], pairMap.get(preferences[x][u]), x)){
          count++;
          break;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] preferences = {
      {1,3,2},
      {0,2,3},
      {3,1,0},
      {2,0,1}};
    int[][] pairs = {{2,1},{3,0}};
    System.out.println(new S1583().unhappyFriends(n, preferences, pairs));
  }
}

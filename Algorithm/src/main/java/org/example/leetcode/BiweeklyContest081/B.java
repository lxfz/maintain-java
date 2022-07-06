package org.example.leetcode.BiweeklyContest081;

public class B {
  int[] father;
  int[] size;

  /**
   * 初始化
   */
  private void init(int n) {
    father = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      father[i] = i;
      size[i] = 1;
    }
  }

  /**
   * 查找
   */
  private int getFather(int node) {
    if (father[node] == node) return node;
    return father[node] = getFather(father[node]);
  }

  /**
   * 合并
   */
  private void union(int a, int b) {
    int fa = getFather(a);
    int fb = getFather(b);
    if(fa != fb) {
      father[fa] = fb;
      size[fb] += size[fa];
      size[fa] = 0;
    }
  }

  public long countPairs(int n, int[][] edges) {
    long ans = 0;
    init(n);
    for (int[] edge : edges) {
      union(edge[0], edge[1]);
    }
    for (int i = 0; i < n; i++) {
      if (size[i] != 0) {
        ans += (long) size[i] * (n - size[i]);
      }
    }
    return ans / 2;
  }


  public static void main(String[] args) {
    int n = 7;
    int[][] edges = {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
    B b = new B();
    System.out.println(b.countPairs(n, edges));
  }
}

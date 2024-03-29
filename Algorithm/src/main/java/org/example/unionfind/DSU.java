package org.example.unionfind;

public class DSU {

  int[] parent;

  public DSU(int N) {
    parent = new int[N];
    for (int i = 0; i < N; i++) parent[i] = i;
  }

  public int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    // 把 x 所在的集合 挂到 y 所在的集合；
    parent[find(x)] = find(y);
  }
}

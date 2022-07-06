package org.example.RWTH.R20220620_DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {

  List<List<Integer>> ans = new ArrayList<>();

  public void dfs(int[] nums, int pos, Deque<Integer> comb, int k) {
    comb.addLast(nums[pos]);
    if (comb.size() == k) {
      ans.add(new ArrayList<>(comb));
      comb.removeLast();
      return;
    }
    for (int i = pos+1; i < nums.length; i++) {
        dfs(nums, i, comb, k);
    }
    comb.removeLast();
  }

  public List<List<Integer>> combine(int n, int k) {
    boolean[] visited = new boolean[n];
    int[] nums = new int[n];
    Deque<Integer> comb = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      nums[i - 1] = i;
    }
    for (int i = 0; i < n; i++) {
      dfs(nums, i, comb, k);
    }
    return ans;
  }
}

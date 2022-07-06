package org.example.RWTH.R20220620_DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CombinationSumII {

  public List<List<Integer>> ans = new ArrayList<>();

  public void dfs(int[] candidates, int target, int pos, Deque<Integer> path, int sum, boolean[] visited) {
    if (sum + candidates[pos] > target) {
      return;
    }
    path.addLast(candidates[pos]);
    visited[pos] = true;
    if (sum + candidates[pos] == target) {
      ans.add(new ArrayList<>(path));
    } else {
      for (int i = pos + 1; i < candidates.length; i++) {
        if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
          continue;
        }
        dfs(candidates, target, i, path, sum + candidates[pos], visited);
      }
    }
    path.removeLast();
    visited[pos] = false;
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    boolean[] visited = new boolean[candidates.length];
    for (int i = 0; i < candidates.length; i++) {
      if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
        continue;
      }
      dfs(candidates, target, i, new ArrayDeque<>(), 0, visited);
    }
    return this.ans;
  }


}

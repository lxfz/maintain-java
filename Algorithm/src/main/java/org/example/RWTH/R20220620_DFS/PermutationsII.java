package org.example.RWTH.R20220620_DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class PermutationsII {
  List<List<Integer>> ans = new ArrayList<>();

  public boolean isDuplicate(List<Integer> permutation) {
    boolean duplication = true;
    for (List<Integer> an : this.ans) {
      duplication = true;
      for (int j = 0; j < permutation.size(); j++) {
        if (!Objects.equals(permutation.get(j), an.get(j))) {
          duplication = false;
          break;
        }
      }
      if (duplication) {
        return true;
      }
    }
    return false;
  }

  public void dfs(int[] nums, boolean[] used, Deque<Integer> permutation, int pos) {
    permutation.addLast(nums[pos]);
    used[pos] = true;

    if (permutation.size() == nums.length) {
      List<Integer> list = new ArrayList<>(permutation);
      ans.add(list);
    }
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }
      if (!used[i]) {
        dfs(nums, used, permutation, i);
      }
    }
    permutation.removeLast();
    used[pos] = false;
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    boolean[] used = new boolean[nums.length];
    Deque<Integer> permutation = new ArrayDeque<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }
      dfs(nums, used, permutation, i);
    }
    return this.ans;
  }
}

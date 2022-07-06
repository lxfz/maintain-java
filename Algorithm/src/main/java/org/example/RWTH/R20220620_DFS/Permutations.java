package org.example.RWTH.R20220620_DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {

  List<List<Integer>> ans = new ArrayList<>();

  public void dfs(int[] nums, boolean[] used, Deque<Integer> permutation, int pos) {
    permutation.addLast(nums[pos]);
    used[pos] = true;

    if (permutation.size() == nums.length) {
      ans.add(new ArrayList<>(permutation));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!used[i]) {
        dfs(nums, used, permutation, i);
      }
    }
    permutation.removeLast();
    used[pos] = false;
  }

  public List<List<Integer>> permute(int[] nums) {
    boolean[] used = new boolean[nums.length];
    Deque<Integer> permutation = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      dfs(nums, used, permutation, i);
    }
    return this.ans;
  }


  public static void main(String[] args) {
    Permutations permutations = new Permutations();

  }
}

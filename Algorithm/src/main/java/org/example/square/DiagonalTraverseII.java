package org.example.square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverseII {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<int[]> list = new ArrayList<>();
    int rows = nums.size();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < nums.get(i).size(); j++) {
        list.add(new int[]{i + j, j, nums.get(i).get(j)});
      }
    }
    Collections.sort(list, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });
    int[] ans = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i)[2];
    }
    return ans;
  }
}

package org.example.dp;

import java.util.Arrays;
import java.util.List;

public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    int[] f = new int[triangle.size()];
    Arrays.fill(f, Integer.MAX_VALUE);
    f[0] = triangle.get(0).get(0);
    for (int i = 1; i < triangle.size(); i++) {
      for (int j = i; j >= 0; j++) {
        if (j > 0) {
          f[j] = Math.min(f[j], f[j - 1]) + triangle.get(i).get(j);
        } else {
          // 坐边界
          f[j] = f[j] + triangle.get(i).get(j);
        }
      }
    }
    int ans = f[0];
    for (int i = 1; i < triangle.size(); i++) {
      ans = Math.min(ans, f[i]);
    }
    return ans;
  }
}

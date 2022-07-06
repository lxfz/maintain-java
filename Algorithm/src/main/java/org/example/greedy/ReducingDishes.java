package org.example.greedy;

import java.util.Arrays;

public class ReducingDishes {

  public int maxSatisfaction(int[] satisfaction) {
    Arrays.sort(satisfaction);
    int presum = 0;
    int ans = 0;
    for (int i = satisfaction.length - 1; i >= 0; i--) {
      if (satisfaction[i] + presum > 0) {
        presum = satisfaction[i] + presum;
        ans += presum;
      }
    }
    return ans;
  }
}

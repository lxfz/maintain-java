package org.example.RWTH.R20220605_DP_Package01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1626. Best Team With No Conflicts
 */
public class BestTeamWithNoConflicts {

  public int bestTeamScore(int[] scores, int[] ages) {
    int[][] arr = new int[scores.length][2];
    for (int i = 0; i < scores.length; i++) {
      arr[i][0] = scores[i];
      arr[i][1] = ages[i];
    }
    Arrays.sort(arr, (o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o1[0] - o2[0];
      }
      return o1[1] - o2[1];
    });

    int[] dp = new int[scores.length];
    dp[0] = arr[0][0];
    for (int i = 1; i < scores.length; i++) {
      dp[i] = arr[i][0];
      for (int j = 0; j < i; j++) {
        if (arr[j][0] <= arr[i][0]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i][0]);
        }
      }
    }

    int ans = 0;
    for (int x : dp) {
      ans = Math.max(ans, x);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] scores = {4, 5, 6, 5};
    int[] ages = {2, 1, 2, 1};
    BestTeamWithNoConflicts bestTeamWithNoConflicts = new BestTeamWithNoConflicts();
    System.out.println(bestTeamWithNoConflicts.bestTeamScore(scores, ages));
  }
}

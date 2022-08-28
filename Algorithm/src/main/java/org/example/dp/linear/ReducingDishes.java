package org.example.dp.linear;

import java.util.Arrays;

public class ReducingDishes {

    public int maxSatisfaction(int[] satisfaction) {
        int len = satisfaction.length;
        int[][] dp = new int[len + 1][len + 1];

        for (int i = 1; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        Arrays.sort(satisfaction);
        int res = 0;

        for (int i = 1; i <= len; i++) {
            for (int t = 1; t <= i; t++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j][t - 1] > Integer.MIN_VALUE) {
                        dp[i][t] = Math.max(dp[i][t], dp[j][t - 1] + satisfaction[i - 1] * t);
                        res = Math.max(res, dp[i][t]);
                    }
                }
            }
        }
        return res;
    }

}

package org.example.dp;

public class OnesAndZeroes {
  public int findMaxForm(String[] strs, int m, int n) {
    int len = strs.length;
    int[] num0 = new int[len];
    int[] num1 = new int[len];
    int[][] dp = new int[len][3];
    int ans = 0;

    for (int i = 0; i < len; i++) {
      for (char c : strs[i].toCharArray()) {
        if (c == '0') {
          num0[i]++;
        } else {
          num1[i]++;
        }
      }
    }

    dp[0][2] = 1;
    dp[0][0] = num0[0];
    dp[0][1] = num1[0];
    if (num0[0] <= m && num1[0] <= n) {
      ans = 1;
    }
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j][0] + num0[i] <= m && dp[j][1] + num1[i] <= n) {
          if (dp[j][2] + 1 > dp[i][2]) {
            dp[i][2] = dp[j][2] + 1;
            dp[i][0] = dp[j][0] + num0[i];
            dp[i][1] = dp[j][1] + num1[i];
            ans = Math.max(ans, dp[i][2]);
          }
        }
      }
    }
    return ans;
  }

}

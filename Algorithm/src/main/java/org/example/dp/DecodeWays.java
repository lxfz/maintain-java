package org.example.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeWays {
  public int numDecodings(String s) {
    Set<String> set = new HashSet<>();
    int[] dp = new int[s.length()];
    for (int i = 1; i <= 26; i++) {
      set.add(Integer.toString(i));
    }
    dp[0] = set.contains(s.substring(0, 1)) ? 1 : 0;
    for (int i = 1; i < s.length(); i++) {
      if (set.contains(s.substring(i, i + 1))) {
        dp[i] += dp[i - 1];
      }
      if (i > 1 && set.contains(s.substring(i - 1, i + 1))) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[s.length() - 1];
  }


}

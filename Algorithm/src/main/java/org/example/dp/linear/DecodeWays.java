/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 */

package org.example.dp.linear;

import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
  public int numDecodings(String s) {
    int[] dp = new int[s.length()];

    Set<String> set = new HashSet<>();
    for (int i = 1; i <= 26; i++) {
      set.add(Integer.toString(i));
    }

    // corner case
    dp[0] = set.contains(s.substring(0, 1)) ? 1 : 0;
    if(s.length() > 1) {
      // 可以把set改成直接判断数字的范围
      if (set.contains(s.substring(1, 2))) {
        dp[1] = dp[0];
      }

      if (set.contains(s.substring(0, 2))) {
        dp[1] += 1;
      }
    }

    for (int i = 2; i < s.length(); i++) {
      // s[i] can be decoded
      if (set.contains(s.substring(i, i + 1))) {
        dp[i] += dp[i - 1];
      }

      // s[i-1, i] can be decoded
      if (set.contains(s.substring(i - 1, i + 1))) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length() - 1];
  }

  public static void main(String[] args) {
    String s = "12";
    DecodeWays decodeWays = new DecodeWays();
    System.out.println(decodeWays.numDecodings(s));
  }
}

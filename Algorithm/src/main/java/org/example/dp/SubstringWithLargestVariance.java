package org.example.dp;

import java.util.Arrays;

public class SubstringWithLargestVariance {

  public int convert2Value(int a, int b, char c) {
    if (c == a + 'a') {
      return 1;
    } else if (c == b + 'a') {
      return -1;
    }
    return 0;
  }

  public int largestVariance(String s) {
    int ans = 0;
    int tempAns = 0;
    int[] dp = new int[s.length()];
    int currentValue = 0;
    boolean bAppear = false;
    for (int a = 0; a < 26; a++) {
      for (int b = 0; b < 26; b++) {
        Arrays.fill(dp, 0);
        bAppear = false;
        tempAns = 0;
        if (a == b) continue;
        dp[0] = convert2Value(a, b, s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
          currentValue = convert2Value(a, b, s.charAt(i));
          if (dp[i-1] + currentValue >=  currentValue) {
            dp[i] = dp[i-1] + currentValue;
          } else {
            dp[i] = currentValue;
            bAppear = false;
          }
          tempAns = Math.max(dp[i], tempAns);
          if (s.charAt(i) == b + 'a') {
            bAppear = true;
          }
        }
        if (bAppear) {
          ans = Math.max(ans, tempAns);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    SubstringWithLargestVariance solution = new SubstringWithLargestVariance();
    String s = "abcde";
    System.out.println(solution.largestVariance(s));
  }
}

package org.example.dp.palindrome;

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = true;
    }
    // 区间长度
    for (int L = 2; L <= s.length(); L++) {
      // 左
      for (int i = 0; i < s.length(); i++) {
        int j = i + L - 1;
        if (j >= s.length())
          break;
        if (s.charAt(i) == s.charAt(j)) {
          if (L == 2) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }
        if (dp[i][j]) {
          start = i;
          end = j;
        }
      }
    }
    return s.substring(start, end + 1);
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
    System.out.println(solution.longestPalindrome("bb"));
  }
}

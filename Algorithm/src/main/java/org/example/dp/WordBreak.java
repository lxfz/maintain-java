package org.example.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = i; j > 0; j--) {
        if (dp[j-1] && wordDict.contains(s.substring(j-1, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    String s = "a";
    List<String> wordDict = Arrays.asList("a");
    WordBreak wordBreak = new WordBreak();
    System.out.println(wordBreak.wordBreak(s, wordDict));
  }
}

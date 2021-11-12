package org.example.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class S0188 {
  public int maxProfit_fail(int k, int[] prices) {
    List<Integer> profits = new ArrayList<>();
    int i = 0;
    int valley = 0, peak = 0;
    int ans = 0;
    while(i < prices.length -1) {
      while(i<prices.length-1 && prices[i] >= prices[i+1]) i++;
      valley = prices[i];

      while(i<prices.length-1 && prices[i] <= prices[i+1]) i++;
      peak = prices[i];
      profits.add(peak - valley);

    }
    // System.out.println(profits.size());
    Collections.sort(profits);
    for(int x : profits) {
      System.out.println(x);
    }
    for(int j=1; j<=k && j<=profits.size(); j++) ans += profits.get(profits.size() - j);
    return ans;
  }

  public int maxProfit(int k, int[] prices) {
    if(k==0 || prices.length == 0) return 0;
    int[][] dp = new int[k+1][prices.length];
    for(int i=1; i<=k; i++) {
      for(int j=1; j<prices.length; j++) {
        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][0] + prices[j] - prices[0]);
        for(int h=1; h<=j-1; h++) {
          dp[i][j] = Math.max(dp[i][j], dp[i-1][h] + prices[j] - prices[h]);
        }
      }
    }
    return dp[k][prices.length-1];
  }

  public static void main(String[] args) {
    S0188 s = new S0188();
    int k = 2;
    int[] prices = new int[]{1,2,4,2,5,7,2,4,9,0};
    System.out.println(s.maxProfit(k, prices));
  }
}

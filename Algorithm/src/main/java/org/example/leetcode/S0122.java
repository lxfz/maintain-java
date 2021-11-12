package org.example.leetcode;

public class S0122 {
  public int maxProfit(int[] prices) {
    int[] f = new int[prices.length];
    for(int i=1; i<prices.length; i++) {
      f[i] = f[i-1];
      for(int j=i-1; j>=0; j--) {
        if(f[i] < f[j] + prices[i] - prices[j]) {
          f[i] = f[j] + prices[i] - prices[j];
        }
      }
    }
    return f[prices.length-1];   
  }
}

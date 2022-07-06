package org.example.dp.linear;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock {
  public int maxProfit(int[] prices) {
    int minPriceSoFar = Integer.MAX_VALUE;
    int maxProfitSoFar = 0;
    for (int i = 0; i < prices.length; i++) {
      maxProfitSoFar = Math.max(maxProfitSoFar, prices[i] - minPriceSoFar);
      minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
    }
    return maxProfitSoFar;
  }

  public static void main(String[] args) {
    int[] prices = {};
    BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new BestTimetoBuyandSellStock();
    System.out.println(bestTimetoBuyandSellStock.maxProfit(prices));
  }
}

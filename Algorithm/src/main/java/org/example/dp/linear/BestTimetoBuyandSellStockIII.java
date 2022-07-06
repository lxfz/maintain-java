package org.example.dp.linear;

public class BestTimetoBuyandSellStockIII {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int[] dpA = new int[prices.length];
    int[] dpB = new int[prices.length];
    int minPriceSoFar = prices[0];
    int maxPriceSoFar = prices[prices.length - 1];

    for (int i = 1; i < prices.length; i++) {
      dpA[i] = Math.max(dpA[i - 1], prices[i] - minPriceSoFar);
      minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
    }

    for (int i = prices.length - 2; i >= 0; i--) {
      dpB[i] = Math.max(dpB[i + 1], maxPriceSoFar - prices[i]);
      maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
    }

    int res = 0;
    for (int i = 0; i < prices.length; i++) {
      res = Math.max(res, dpA[i] + dpB[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] prices = {7,6,4,3,1};
    BestTimetoBuyandSellStockIII bestTimetoBuyandSellStockIII = new BestTimetoBuyandSellStockIII();
    System.out.println(bestTimetoBuyandSellStockIII.maxProfit(prices));
  }
}

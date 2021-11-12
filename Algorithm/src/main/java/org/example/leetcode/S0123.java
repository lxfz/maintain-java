package org.example.leetcode;

public class S0123 {

  public int solve(int[] prices, int left, int right) {
    if(right <= left) return 0;
    int min = prices[left];
    int ans = 0;
    for(int i=left+1; i<=right; i++) {
      ans = Math.max(ans, prices[i] - min);
      min = Math.min(min, prices[i]);
    }
    return ans;
  }

  public int maxProfit_1(int[] prices) {
    int ans = 0;
    ans = Math.max(solve(prices, 0, prices.length-1), ans);
    for(int i=0; i<prices.length; i++) {
      ans = Math.max(solve(prices, 0, i)+solve(prices, i+1, prices.length-1), ans);
    }
    return ans;
  }
  
  public int maxProfit_v2(int[] prices) {
    int max = 0;
    int secMax = 0;
    int curSum = 0;
    int thisMax = 0;
    int f[] = new int[prices.length-1];
    for(int i=0; i<f.length; i++) {
      f[i] = prices[i+1] - prices[i];
    }
    for(int i=0; i<f.length; i++) {
      curSum += f[i];
      if(curSum <= 0 ) {
        curSum = 0;
        if(max < thisMax) {
          secMax = max;
          max = thisMax;
        } else if(secMax < thisMax) {
          secMax = thisMax;
        }
        thisMax = 0;
      } else {
        if(thisMax < curSum)  thisMax = curSum;
      }
    }
    if(max < thisMax) {
      secMax = max;
      max = thisMax;
    }
    return max + secMax;
  }

  public int maxProfit_v3(int[] prices) {
    int f[] = new int[prices.length-1];
    int g[] = new int[f.length];
    int h[] = new int[f.length];
    int ans = 0;
    for(int i=0; i<f.length; i++) {
      f[i] = prices[i+1] - prices[i];
    }

    g[0] = f[0] >= 0 ? f[0] : 0;
    for(int i=1; i<f.length; i++) {
      if(f[i] <=0 ) g[i] = g[i-1];
      else g[i] = g[i-1] + f[i];
    }

    h[f.length-1] = f[f.length-1] >= 0 ? f[f.length-1] : 0;
    for(int i=f.length-2; i>=0; i--) {
      if(f[i]<=0) h[i] = h[i+1];
      else h[i] = h[i+1] + f[i];
    }
    ans = g[f.length-1];
    for(int i=0; i<f.length-1; i++) {
      ans = Math.max(ans, g[i] + h[i+1]);
    }
    return ans;
  }

  public int maxProfit(int[] prices) {
    int f[] = new int[prices.length];
    int g[] = new int[prices.length];
    int ans = 0;

    int min = prices[0];
    int max = prices[prices.length-1];

    for(int i= 1; i<prices.length; i++) {
      f[i] = Math.max(f[i-1], prices[i] - min);
      min = Math.min(min, prices[i]);
    }
    for(int i=prices.length-2; i>=0; i--) {
      g[i] = Math.max(g[i+1], max - prices[i]);
      max = Math.max(max, prices[i]);
    }
    ans = f[f.length-1];
    for(int i=0; i<f.length-1; i++) {
      ans = Math.max(ans, f[i] + g[i+1]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] prices = {3,3,5,0,0,3,1,4};
    System.out.println(new S0123().maxProfit(prices));
  }
  
}

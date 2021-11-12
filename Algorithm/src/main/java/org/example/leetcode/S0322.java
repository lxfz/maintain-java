package org.example.leetcode;

public class S0322 {

  public static int coinChange(int[] coins, int amount) {
    int[] f = new int[amount+1];
    for(int i=0; i<f.length; i++) f[i] = -1;
    for(int i=0; i<coins.length && coins[i] <= amount; i++) f[coins[i]] = 1;
    f[0] = 0;
    for(int i=1; i<f.length; i++) {
      int min = Integer.MAX_VALUE;
      boolean exist = false;
      for(int j=0; j<coins.length; j++) {
        if(i - coins[j] >= 0 && f[i - coins[j]] >= 0) {
          min = Integer.min(min, f[coins[j]] + f[i - coins[j]]);
          exist = true;
        }
      }
      if(!exist) {
        f[i] = -1;
      } else {
        f[i] = min;
      }
    }
    return f[amount];
  }

  public static void main(String[] args) {
    
  }
  
}

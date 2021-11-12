package org.example.leetcode;

public class S0518 {

  static class Solution {
    public int change(int amount, int[] coins) {
      int[] a = new int[amount+1];
      int[] b = new int[amount+1];
      for(int i=0; i<coins.length; i++) b[coins[i]] = 1;
      a[0] = 1;
      for(int i=1; i<=amount; i++) {
        for(int c : coins) 
          if(c<=i) a[i] += a[i-c];
      }
      return a[amount];
    }
  }

  public static void main(String[] args) {
    int amount = 5;
    int[] coins = {1, 2, 5};
    Solution s = new Solution();
    System.out.println(s.change(amount, coins));
  }
  
}
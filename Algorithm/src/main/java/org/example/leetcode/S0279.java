package org.example.leetcode;

public class S0279 {

  public int numSquares(int n) {
    int[] num = new int[n+1];
    num[1] = 1;
    int root = 0;
    for(int i=2; i<=n; i++) {
      root =  (int)Math.sqrt(i);
      if(root * root == i) 
        num[i] = 1;
      else {
        num[i] = Integer.MAX_VALUE;
        for(int j=1; j<=i/2; j++) {
          num[i] = Math.min(num[i], num[j] + num[i-j]);
        }
      }
    }
    return num[n];
  }
  
}

package org.example.leetcode;

public class S0070 {

  public int climbStairs(int n) {
    int a = 1, b =2, t;
    if(n == 1) return a;
    else if (n == 2) return b;
    for(int i=3; i<=n; i++) {
      t = a+ b;
      a = b;
      b = t;
    }
    return b;    
  }


  public static void main(String[] args) {
    int n = 4;
    System.out.println(new S0070().climbStairs(n));
  }
  
}
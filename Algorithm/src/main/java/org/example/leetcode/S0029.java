package org.example.leetcode;


public class S0029 {

  public int divide(int dividend, int divisor) {
    int flag = 1;
    int result = 0;

    if(divisor == 1) return dividend;
    if(divisor == -1) {
      if(dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
      else return -dividend;
    }

    if(dividend < 0) flag *= -1;  else dividend = -dividend;
    if(divisor < 0) flag *=-1; else divisor = -divisor;
    
    while(dividend <= divisor) {
      result -= 1;
      dividend -= divisor;
      if(flag < 0 && result == Integer.MIN_VALUE) break;
      if(flag > 0 && -result == Integer.MAX_VALUE) break;
    }
    return result * (-flag);
  }

  public static void main(String[] args) {
    System.out.println(new S0029().divide(-2147483648, 1));
  }
}
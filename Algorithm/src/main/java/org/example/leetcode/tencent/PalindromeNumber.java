package org.example.leetcode.tencent;

public class PalindromeNumber {

  private long revertNumber(long x) {
    long res = 0;
    while (x > 0) {
      res = res * 10 + (x % 10);
      x /= 10;
    }
    return res;
  }

  public boolean isPalindrome(int x) {
    long reverted = revertNumber(x);
    return x == reverted;
  }
}

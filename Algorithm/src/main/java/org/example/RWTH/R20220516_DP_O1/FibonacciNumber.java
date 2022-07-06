package org.example.RWTH.R20220516_DP_O1;

/**
 * 509. Fibonacci Number
 **/
public class FibonacciNumber {
  public int fib(int n) {
    int a = 0;
    int b = 1;
    int t = 0;

    if (n <= 1) return n;

    for (int i = 2; i <= n; i++) {
      t = a + b;
      a = b;
      b = t;
    }
    return b;
  }

  public static void main(String[] args) {
    FibonacciNumber s = new FibonacciNumber();
    System.out.println(s.fib(4));
  }
}

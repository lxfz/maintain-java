package org.example.dp.PrefixSum;

import java.util.Scanner;

public class PrefixSum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int q = in.nextInt();
    int l, r;
    long[] f = new long[n+1];
    for (int i = 1; i <=n; i++) {
      f[i] = in.nextInt() + f[i-1];
    }
    for (int i = 0; i < q; i++) {
      l = in.nextInt();
      r = in.nextInt();
      System.out.println(f[r] - f[l-1]);
    }
  }
}

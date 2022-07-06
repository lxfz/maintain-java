package org.example.dp.difference;

import java.util.Scanner;

public class Difference1D {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int l, r, k;
    long[] a = new long[n + 1];
    long[] b = new long[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      b[i] = a[i] - a[i - 1]; // 求差分数组
    }

    while (m-- > 0) {
      l = in.nextInt();
      r = in.nextInt();
      k = in.nextInt();
      b[l] += k;
      if (r < n) b[r+1] -= k;
    }
    for(int i=1; i<=n; i++) {
      b[i] = b[i] + b[i-1];
      System.out.print(b[i]+ " ");
    }

  }
}

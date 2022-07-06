package org.example.dp.PrefixSum;

import java.util.Scanner;

public class PrefixSum2D {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int q = in.nextInt();

    long[][] f = new long[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        f[i][j] = in.nextInt() + f[i][j - 1] + f[i - 1][j] - f[i - 1][j - 1];
      }
    }
    int x1, x2, y1, y2;
    for (int i = 0; i < q; i++) {
      x1 = in.nextInt();
      y1 = in.nextInt();
      x2 = in.nextInt();
      y2 = in.nextInt();

      System.out.println(f[x2][y2] - f[x2][y1 - 1] - f[x1 - 1][y2] + f[x1 - 1][y1 - 1]);
    }
  }
}

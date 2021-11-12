package org.example.kickstart.G2020RoundB;

import java.util.*;
import java.io.*;

public class Solution4 {

  public static double solve(int w, int h, int l, int u, int r, int d) {
    double[][] f = new double[w][h];
    double eps = 1.0e-7;
    f[0][0] = 1.0;
    for (int i = 1; i < w; i++) {
      f[i][0] = 0.5 * f[i - 1][0];
      if (i >= l && i <= r && u <= 0 && d >= 0) {
        f[i][0] = 0.0;
      }
    }
    for (int i = 1; i < h; i++) {
      f[0][i] = 0.5 * f[0][i - 1];
      if (l <= 0 && 0 <= r && u <= i && i <= d) {
        f[0][i] = 0.0;
      }
    }

    for (int i = 1; i < w; i++) {
      for (int j = 1; j < h; j++) {
        if (i == w - 1 && j == h - 1) {
          f[i][j] = f[i][j - 1] + f[i - 1][j];
        } else if (i == w - 1) {
          f[i][j] = f[i][j - 1] + 0.5 * f[i - 1][j];
        } else if (j == h - 1) {
          f[i][j] = f[i - 1][j] + 0.5 * f[i][j - 1];
        } else {
          f[i][j] = 0.5 * f[i][j - 1] + 0.5 * f[i - 1][j];
        }
        if (i >= l && i <= r && j >= u && j <= d) {
          f[i][j] = 0.0;
        }
        if(f[i][j] < eps) f[i][j] = 0.0;
      }
    }
    return f[w - 1][h - 1];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int w, h, l, u, r, d;
    for (int i = 1; i <= t; ++i) {
      w = in.nextInt();
      h = in.nextInt();
      l = in.nextInt();
      u = in.nextInt();
      r = in.nextInt();
      d = in.nextInt();
      System.out.println("Case #" + i + ": " + solve(w, h, l-1, u-1, r-1, d-1));
    }
  }

}

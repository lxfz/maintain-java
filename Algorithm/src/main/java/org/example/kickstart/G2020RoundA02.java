package org.example.kickstart;

import java.util.*;
import java.io.*;

public class G2020RoundA02 {

  public static int solve(int[][] a, int n, int k, int p) {
    int f[][] = new int[n+1][p+1];
    int curSum = 0;
    for(int i=1; i<=n; i++) {
      for(int j=0; j<=p; j++) {
        curSum = 0;
        f[i][j] = f[i-1][j];
        for(int h=1; h<=k && h<=j; h++) {
          curSum += a[i-1][h-1];
          f[i][j] = Math.max(f[i][j], f[i-1][j-h] + curSum);
        }
      }
    }
    return f[n][p];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int n, k, p;
    int[][] a= new int[51][31];
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      k = in.nextInt();
      p = in.nextInt();
      for(int h=0; h<n; h++) {
        for(int j=0; j<k; j++) {
          a[h][j] = in.nextInt();
        }
      }
      System.out.println("Case #" + i + ": " + solve(a, n, k, p));
    }
  } 
}

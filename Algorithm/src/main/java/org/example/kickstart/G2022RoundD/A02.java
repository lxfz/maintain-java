package org.example.kickstart.G2022RoundD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A02 {




  public static int solve(int n, int m, int[] a, int[] b, int k) {
    return 0;
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int n, m, k;
    int[] a, b;
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      a = new int[n];
      for (int j = 0; j < n; j++) {
        a[j] = in.nextInt();
      }

      m = in.nextInt();
      b = new int[m];
      for (int j=0; j<m; j++) {
        b[j] = in.nextInt();
      }
      k = in.nextInt();
      System.out.println("Case #" + i + ": " + solve(n, m, a, b, k));
    }
  }


  
}
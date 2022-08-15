package org.example.kickstart.G2022RoundD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A01 {

  public static int solve(int[] a, int n, int m) {
    return 0;
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int n, m;
    int[] a;
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      m = in.nextInt();
      a = new int[n];
      for (int j = 0; j < n; j++) {
        a[j] = in.nextInt();
      }
      System.out.println("Case #" + i + ": " + solve(a, n, m));
    }
  }


}
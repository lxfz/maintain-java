package org.example.kickstart.G2020RoundH;

import java.util.*;
import java.io.*;

public class Solution01 {
  
  public static long solve(long n, long k, long s) {
    return Long.min(n+k, 2*k + n - 2*s);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    long n, k, s;
    for (int i = 1; i <= t; ++i) {
      n = in.nextLong();
      k = in.nextLong();
      s = in.nextLong();
      System.out.println("Case #" + i + ": " + solve(n, k, s));
    }
  } 
}
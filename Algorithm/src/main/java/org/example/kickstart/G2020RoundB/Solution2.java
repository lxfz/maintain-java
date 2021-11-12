package org.example.kickstart.G2020RoundB;
import java.util.*;
import java.io.*;



public class Solution2 {

  public static long solve(long[] a, int n, long d) {
    long ans = d;
    for(int i=n-1; i>=0; i--) {
      ans = (ans / a[i]) * a[i];
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int n;
    long d;
    long[] a = new long[1001];
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      d = in.nextLong();
      for(int j=0; j<n; j++) {
        a[j] = in.nextLong();
      }
      System.out.println("Case #" + i + ": " + solve(a, n, d));
    }
  } 
}

package org.example.kickstart.G2020RoundG;

import java.util.*;
import java.io.*;



public class Solution3 {
  
  public static long solve(int w, int n, long[] x) {
    long half = n / 2;
    long ans = Long.MAX_VALUE;
    long temp = 0;
    for(int i=1; i<=n; i++) {
      temp = 0;
      for(int j=0; j<w; j++) {
        if(Math.abs(x[j] - i) <= half)  {
          temp += Math.abs(x[j]-i);
        } else {
          temp += n - Math.abs(x[j]-i);
        }
      }
      ans = Math.min(ans, temp);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int w=0, n = 0;
    long[] x = new long[100001];
    for (int i = 1; i <= t; ++i) {
      w = in.nextInt();
      n = in.nextInt();
      for(int k=0; k<w; k++) {
        x[k] = in.nextLong();
      }
      System.out.println("Case #" + i + ": " + solve(w, n, x));
    }
  } 
}

package org.example.kickstart;

import java.util.*;
import java.io.*;

public class G2020RoundA01 {
  
  public static int solve_01(int[] a, int b, int n) {
    if(n == 0) return 0;
    int[][] f = new int[n][b+1];
    for(int i=a[0]; i<=b; i++) {
      f[0][i] = 1;
    }

    for(int i=1; i<n; i++) {
      for(int j=0; j<=b; j++) {
        f[i][j] = f[i-1][j];
        if(j>=a[i])
          f[i][j] = Math.max(f[i][j], f[i-1][j-a[i]] + 1);
        // System.out.println(i + " " + j + " " + f[i][j]);
      }
    }
    return f[n-1][b];
  }

  public static int solve(int[] a, int b, int n) {
    int ans = 0;
    int[] p = new int [1001];
    for(int i=0; i<n; i++) {
      p[a[i]]++;
    }
    for(int i=0; i<p.length; i++) {
      while(p[i]>0 && b >= i) {
        p[i]--;
        b -= i;
        ans++;
      } 
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int n;
    int b;
    int[] a = new int [1_000_001];
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      b = in.nextInt();
      for(int j=0; j<n; j++) {
        a[j] = in.nextInt();
      }
      System.out.println("Case #" + i + ": " + solve(a, b, n));
    }
  } 
}

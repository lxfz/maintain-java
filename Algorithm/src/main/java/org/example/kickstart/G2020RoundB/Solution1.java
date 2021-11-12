package org.example.kickstart.G2020RoundB;

import java.util.*;
import java.io.*;


public class Solution1 {

  public static int solve(int[] a, int n) {
    int ans = 0;
    for(int i = 1; i<n-1; i++) {
      if(a[i] > a[i-1] && a[i] > a[i+1]) ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int n;
    int[] a = new int[101];
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      for(int j=0; j<n; j++) {
        a[j] = in.nextInt();
      }
      System.out.println("Case #" + i + ": " + solve(a,n));
    }
  } 
  
}

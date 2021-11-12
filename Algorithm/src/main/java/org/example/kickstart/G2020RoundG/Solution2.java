package org.example.kickstart.G2020RoundG;

import java.util.*;
import java.io.*;



public class Solution2 {
  
  public static long solve(int[][] a, int n) {
    long ans = 0;
    long temp = 0;
    int i=0;
    int j =0;
    for(int k=0; k<n; k++) {
      i = 0;
      j = k;
      temp = 0;
      while(i<n && j<n) {
        temp += a[i][j];
        i++;
        j++;
      }
      ans = Math.max(ans, temp);
    }

    for(int k=1; k<n; k++) {
      i = k;
      j = 0;
      temp = 0;
      while(i<n && j<n) {
        temp += a[i][j];
        i++;
        j++;
      }
      ans = Math.max(ans, temp);
    }
    return  ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int[][] a = new int[1001][1001];
    int n=0;
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      for(int k=0; k<n; k++) {
        for(int j=0; j<n; j++) {
          a[k][j] = in.nextInt();
        }
      }
      System.out.println("Case #" + i + ": " + solve(a, n));
    }
  } 
}

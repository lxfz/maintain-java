package org.example.kickstart.G2021A;

import java.util.*;
import java.io.*;


public class Solution1 {
  public static int count(int x, int y){
    if (x<2 || y<2) return 0;
    return Math.min(x/2, y) + Math.min(x, y/2) - 2;
  }

  public static long sovle(int[][] A, int r, int c){
    long ans = 0;
    int[][] top = new int[r+2][c+2];
    int[][] bottom = new int[r+2][c+2];
    int[][] left = new int[r+2][c+2];
    int[][] right = new int[r+2][c+2];

    for(int i=1; i<=r; i++) {
      for(int j=1; j<=c; j++) {
        if(A[i][j] == 1) {
          top[i][j] = top[i-1][j] + 1;
          left[i][j] = left[i][j-1] + 1;
        }
      }
    }

    for(int i=r; i>=1; i--){
      for(int j=c; j>=1; j--) {
        if(A[i][j] == 1) {
          bottom[i][j] = bottom[i+1][j] + 1;
          right[i][j]  = right[i][j+1] + 1;
        }
      }
    }

    for(int i=1; i<=r; i++) {
      for(int j=1; j<=c; j++) {
        // System.out.println("ij:" + i + " " + j +  " " +left[i][j] + " " + top[i][j] + "\t "+ right[i][j] + " " +bottom[i][j]);
        ans += count(left[i][j], top[i][j]) + 
               count(right[i][j], top[i][j]) +
               count(left[i][j], bottom[i][j]) +
               count(right[i][j], bottom[i][j]);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int r, c;
    for (int i = 1; i <= t; ++i) {
      r = in.nextInt();
      c = in.nextInt();
      int[][] A = new int[r+2][c+2];
      for(int k=1; k<=r; k++) {
        for(int h=1; h<=c; h++) {
          A[k][h] = in.nextInt();
        }
      }
      System.out.println("Case #" + i + ": " + sovle(A, r, c));
    }
  }
}

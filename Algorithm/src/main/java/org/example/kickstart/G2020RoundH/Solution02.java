package org.example.kickstart.G2020RoundH;

import java.util.*;
import java.io.*;

public class Solution02 {
  public static long solve_n(long n) {
    String s = String.valueOf(n);
    long f[][][] = new long[s.length()+1][2][2];
    if (s.length() % 2 == 1) {
      f[s.length()][0][0] = 5;
      f[s.length()][0][0] = 5;
      if ((s.charAt(s.length()-1) - '0') % 2 == 1) {
        f[s.length()][1][0] = (s.charAt(s.length()-1) - '0'  + 1) / 2;
        f[s.length()][1][1] = (s.charAt(s.length()-1) - '0'  + 1) / 2;
      } else {
        f[s.length()][1][0] = (s.charAt(s.length()-1) - '0') / 2;
        f[s.length()][1][1] = (s.charAt(s.length()-1) - '0') / 2;
      }
    } else {
      f[s.length()][0][0] = 5;
      f[s.length()][0][1] = 5;
      f[s.length()][1][0] = (s.charAt(s.length()-1) - '0') / 2 + 1;
      f[s.length()][1][1] = (s.charAt(s.length()-1) - '0') / 2+1;
    }

    for(int i=s.length()-1; i>0; i--) {
      if (i % 2 == 1) {
        if ((s.charAt(i-1) -'0') % 2 == 1) {
          f[i][0][0] = 5 * f[i+1][0][1];
          f[i][0][1] = 5 * f[i+1][0][1];
          f[i][1][0] = ((s.charAt(i-1) - '0') / 2) * f[i+1][0][1] + f[i+1][1][1];
          f[i][1][1] = ((s.charAt(i-1) - '0') / 2) * f[i+1][0][1] + f[i+1][1][1];
        } else {
          f[i][0][0] = 5 * f[i+1][0][1];
          f[i][0][1] = 5 * f[i+1][0][1];
          f[i][1][0] = ((s.charAt(i-1) - '0') / 2) * f[i+1][0][1];
          f[i][1][1] = ((s.charAt(i-1) - '0') / 2) * f[i+1][0][1];
        }

      } else {
        if ((s.charAt(i-1)-'0') % 2 == 1) {
          f[i][0][0] = 4 * f[i+1][0][1] + f[i+1][0][0];
          f[i][0][1] = 5 * f[i+1][0][1];
          int x = (s.charAt(i-1) - '0' + 1) / 2;
          f[i][1][0] = (x-1) * f[i+1][0][1] + f[i+1][0][0];
          f[i][1][1] = x * f[i+1][0][1];
        } else {
          f[i][0][0] = 4 * f[i+1][0][1] + f[i+1][0][0];
          f[i][0][1] = 5 * f[i+1][0][1];
          int x = (s.charAt(i-1) - '0') / 2 + 1;
          f[i][1][0] = f[i+1][0][0];
          if(x - 2 >= 0) {
            f[i][1][0] = (x-2) * f[i+1][0][1] + f[i+1][0][0] + f[i+1][1][1];
            f[i][1][1] = (x-1) * f[i+1][0][1] + f[i+1][1][1];
          } else {
            f[i][1][0] = f[i+1][1][0];
            f[i][1][1] = f[i+1][1][1];
          }
        }
      }
    }
    return f[1][1][0];
  }
  public static long solve(long l, long r) {
    long result = 0l;
    if (l > r) return result;
    long mid = (l+r) / 2;
    if (l < r) return solve(l, mid) + solve(mid+1, r);
    if (l == r) {
      String s = String.valueOf(l);
      boolean f = true;
      for(int i=0; i<s.length(); i++) {
        if ( (i+1) % 2 != (s.charAt(i) - '0') % 2) {
          f = false;
          break;
        }
      }
      if (f == true) return 1;
      else return 0;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    long l, r;

    for (int i = 1; i <= t; ++i) {
      l = in.nextLong();
      r = in.nextLong();
      System.out.println("Case #" + i + ": " + (solve_n(r) - solve_n(l)));
    }

    System.out.println();
    System.out.println(solve_n(15));
  } 
}
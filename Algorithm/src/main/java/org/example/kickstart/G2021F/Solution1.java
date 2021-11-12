package org.example.kickstart.G2021F;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
public class Solution1 {
  public static long solve(long n, String s) {
    char[] c = s.toCharArray();
    long[] L = new long[s.length()];
    long[] R = new long[s.length()];
    long dis = 2*n;
    for(int i=0; i<s.length(); i++) {
      if(c[i] == '1') {
        dis = 0;
      } else {
        dis += 1;
      }
      L[i] = dis;
    }

    dis = 2*n;
    for(int i=s.length()-1; i>=0; i--) {
      if(c[i] == '1') {
        dis = 0;
      } else {
        dis += 1;
      }
      R[i] = dis;
    }

    long ans = 0;
    for(int i=0; i<s.length(); i++) {
      ans += Math.min(L[i], R[i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    long t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    long n;
    String s;
    for (long i = 1; i <= t; ++i) {
      n = in.nextInt();
      in.nextLine();
      s = in.nextLine();
      // System.out.println(n + " " + s);
      System.out.println("Case #" + i + ": " + solve(n, s));
    }
  } 
  
}

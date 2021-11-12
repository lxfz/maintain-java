package org.example.kickstart.G2020RoundG;

import java.util.*;
import java.io.*;



public class Solution4 {
  
  public static double solve(int[] a, int n) {

    double f[][] = new double[n][n];
    double g[][] = new double[n][n];
    double h[][] = new double[n][n];
    for(int i=0; i<n; i++) g[i][i] = 1.0;
    for(int len = 1; len <=n; len++) {
      for(int i=0; i<n; i++) {
        int j = i+len-1;
        if(j >= n ) break;
        int sum = 0;
        for(int k=1; k<=j; k++) {
          sum += a[k];
        }
        double expect = 0.0;
        for(int k=i; k<j; k++) {
          g[i][j] += g[i][k] * g[k+1][j];
          f[i][j] = (f[i][k] + f[k+1][j] + sum);
          expect += (g[i][k] * g[k+1][j]) * f[i][j];
        }
        f[i][j] = expect;
        g[i][j] *= (1.0 / (n-len+1));
      }
    }
    return f[0][n-1];
  }

  public static double ans = 0.0;
  public static void set1(List<Long> f, double p, long score) {
    if(f.size() == 1) {
      ans += p * score;
    }
    for(int i=0; i<f.size()-1; i++) {
      List<Long> t = new ArrayList<>();
      for(int j=0; j<i; j++) {
        t.add(f.get(j));
      }
      t.add(f.get(i) + f.get(i+1));
      for(int j=i+2; j<f.size(); j++) {
        t.add(f.get(j));
      }
      double ptemp  = 1.0 / (f.size()-1);
      set1(t, p*ptemp, f.get(i)+f.get(i+1)+score);
    }
  }

  public static double solve_1(int[] a, int n) {
    List<Long> f = new ArrayList<>();
    for(int i=0; i<n; i++) f.add((long)a[i]);
    ans = 0.0;
    set1(f, 1.0, 0);
    return ans;
  }

  public static double solve_2(int[] a, int n) {
    double f[][] = new double[n][n];
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        if(i>0) {
          f[i][j] += 1.0/(i+j) * (1 + f[i-1][j]);
        }
        if(j>0) {
          f[i][j] += 1.0/(i+j) * (1 + f[i][j-1]);
        }
        if(i>=2) {
          f[i][j] += (i-1+0.0)/(i+j) * f[i-1][j];
        }
        if(j>=2) {
          f[i][j] += (j-1+0.0)/(i+j) * f[i][j-1];
        }
      }
    }
    double ans = 0.0;
    for(int i=0; i<n; i++) {
      ans += a[i] * f[i][n-1-i];
    }
    return ans;
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int n = 0;
    int[] a = new int[5001];
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      for(int k=0; k<n; k++) {
        a[k] = in.nextInt();
      }
      System.out.println("Case #" + i + ": " + solve_2(a, n));
    }
  } 
}

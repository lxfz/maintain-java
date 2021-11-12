package org.example.kickstart;

import java.util.*;
import java.io.*;

public class S2020RoundA03 {

  public static int solve_v1(int[] a, int n, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    int top = 0;
    for(int i=1; i<n; i++) {
      queue.add(a[i]-a[i-1]);
    }
    while(k>0) {
      top = queue.poll();
      if(top == 1) return 1;
      if(top == 2) {
        queue.add(1);
      } else if(top % 2 == 0) {
        queue.add(top / 2);
        queue.add(top / 2);
      } else {
        queue.add(top / 2);
        queue.add(top / 2 + 1);
      }
      k--;
    }
    if(queue.isEmpty()) return top;
    else return queue.peek();
  }

  public static int solve(int[] a, int n, int k) {
    int[][] f = new int[n][k+1];
    int tempDiff = 0;

    for(int i=1; i<n; i++) {
      for(int j=0; j<=k; j++) {
        f[i][j] = Math.max(f[i-1][j], a[i] - a[i-1]);
        for(int h=1; h<=j; h++) {
          if ((a[i]-a[i-1]-1) <= h) {
            tempDiff = 1;
          } else {
            if (((a[i]-a[i-1]) % (h+1)) == 0) {
              tempDiff = (a[i]-a[i-1])/(h+1);
            } else {
              tempDiff = (a[i]-a[i-1])/(h+1) + 1;
            }
          }
          f[i][j] = Math.min(f[i][j], Math.max(f[i-1][j-h], tempDiff));
        }
      }
    }
    return f[n-1][k];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int n, k;
    int[] a = new int[100001]; 
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      k = in.nextInt();

      for(int j=0; j<n; j++) {
        a[j] = in.nextInt();
      }
      System.out.println("Case #" + i + ": " + solve(a, n, k));
    }
  } 
}
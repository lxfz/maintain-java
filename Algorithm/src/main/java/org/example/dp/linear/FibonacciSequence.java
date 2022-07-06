package org.example.dp.linear;

import java.util.Scanner;

public class FibonacciSequence {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] f = new int[n+1];
    f[1] = 1;
    f[2] = 1;
    for(int i=3; i<=n; i++) {
      f[i] = f[i-1] + f[i-2];
    }
    System.out.println(f[n]);
  }
}

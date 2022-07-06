package org.example.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class RandomNumbers {

  public static void main(String[] args) {
    boolean[] a = new boolean[501];
    Arrays.fill(a, false);
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int val = 0;
    while (n-- > 0) {
      val = in.nextInt();
      a[val] = true;
    }
    for (int i = 1; i < a.length; i++) {
      if (a[i]) {
        System.out.println(i);
      }
    }
  }
}

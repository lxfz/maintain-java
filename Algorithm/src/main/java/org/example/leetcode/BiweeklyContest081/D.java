package org.example.leetcode.BiweeklyContest081;

import java.util.ArrayList;
import java.util.List;

public class D {

  public int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    List<Integer>[] a = new ArrayList[10];

  }
}

package org.example.huawei;

import java.util.Scanner;

public class SodaBottle {

  public static int f(int n) {
    if (n <= 1) return 0;
    if (n == 2 || n == 3) return 1;
    return n / 3 + f(n / 3 + n % 3);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 0;
    do {
      n = in.nextInt();
      if (n != 0) {
        System.out.println(f(n));
      }
    } while (n != 0);
  }
}

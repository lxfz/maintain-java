package org.example.baidu;

import java.util.Scanner;

public class LcmGcd {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextInt();

    System.out.println(n * (n-1) - 1);

  }
}

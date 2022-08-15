package org.example.RWTH.R20220808;

import java.util.Arrays;

public class DecodeWays {

  public int numDecodings_1(String s) {
    int len = s.length();
    int[] f = new int[len + 1];
    f[len] = 1;
    if (s.charAt(len - 1) != '0') f[len - 1] = 1;

    int twoCharValue = 0;

    for (int i = len - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        f[i] = 0;
      } else {
        f[i] += f[i + 1];
        twoCharValue = Integer.parseInt(s.substring(i, i + 2));
        if (twoCharValue > 0 && twoCharValue <= 26) {
          f[i] += f[i + 2];
        }
      }
    }
    return f[0];
  }

  public int numDecodings(String s) {
    int len = s.length();

    int a = 0, b = 0, c = 1;
    if (s.charAt(len - 1) != '0') b = 1;
    for (int i = len - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        a = 0;
      } else {
        a += b;
        if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
          a += c;
        }
      }
      c = b;
      b = a;
      a = 0;
    }
    return b;
  }


  public static void main(String[] args) {
    String s = "226";
    DecodeWays decodeWays = new DecodeWays();
    System.out.println(decodeWays.numDecodings(s));
  }
}

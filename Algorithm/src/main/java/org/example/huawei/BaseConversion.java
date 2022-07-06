package org.example.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseConversion {

  public static Map<Character, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = null;
    int res = 0;
    int pow = 0;
    while (in.hasNextLine()) {
      s = in.nextLine();
      res = 0;
      pow = 1;
      for (int i = s.length() - 1; i >= 2; i--) {
        if (Character.isDigit(s.charAt(i))) {
          res += (s.charAt(i) - '0') * pow;
        } else {
          res += (s.charAt(i) - 'A' + 10) * pow;
        }
        pow *= 16;
      }
      System.out.println(res);
    }
  }
}

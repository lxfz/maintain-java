package org.example.dp.PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABB {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine(); // 跳过n后面的换行符
    long ans = 0;
    char[] s = in.nextLine().toCharArray();
    Map<Character, Integer> m = new HashMap<>();
    for (char c : s) {
      m.put(c, m.getOrDefault(c, 0) + 1);
    }
    for (char c : s) {
      m.put(c, m.get(c) - 1);
      for (char key : m.keySet()) {
        if (c != key) {
          ans += ((long) m.get(key) * (m.get(key) - 1)) / 2;
        }
      }
    }
    System.out.println(ans);
  }
}

package org.example.leetcode.WeeklyContest0293;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B {
  public int maxConsecutive(int bottom, int top, int[] special) {
    int ans = 0;
    List<Integer> a = new ArrayList<>();
    for (int x : special) {
      a.add(x);
    }
    Collections.sort(a);
    for (int i = 1; i < a.size(); i++) {
      ans = Math.max(ans, a.get(i) - a.get(i - 1) - 1);
    }
    if (a.get(0) != bottom) {
      ans = Math.max(ans, a.get(0) - bottom);
    }
    if (a.get(a.size() - 1) != top) {
      ans = Math.max(ans, top - a.get(a.size() - 1));
    }
    return ans;
  }


  public static void main(String[] args) {
    int bottom = 6, top = 8;
    int[] special = {7,6,8};
    B b = new B();
    System.out.println(b.maxConsecutive(bottom, top, special));
  }
}

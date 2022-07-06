package org.example.leetcode.WeeklyContest0293;

public class C {

  public int largestCombination(int[] candidates) {
    int ans = 0;
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count = 0;
      for (int c : candidates) {
        if ((c & (1 << i)) > 0) {
          count++;
        }
      }
      ans = Math.max(ans, count);
    }
    return ans;
  }

  public static void main(String[] args) {
    C c = new C();
    int[] candi = {8,8};
    System.out.println(c.largestCombination(candi));
  }
}

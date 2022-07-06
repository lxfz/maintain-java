package org.example.RWTH.R20220627_String;

public class MinimumChangesToMakeAlternatingBinaryString2 {


  public int minOperations(String s) {
    int cnt0 = 0;
    int cnt1 = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) % 2 != i % 2) {
        cnt0++;
      } else {
        cnt1++;
      }
    }
    return Math.min(cnt0, cnt1);
  }

  public static void main(String[] args) {
    MinimumChangesToMakeAlternatingBinaryString2 solution = new MinimumChangesToMakeAlternatingBinaryString2();
    System.out.println(solution.minOperations("1111"));
  }
}

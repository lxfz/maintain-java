package org.example.RWTH.R20220627_String;

public class MinimumChangesToMakeAlternatingBinaryString {

  public char change(char c) {
    if (c == '0') {
      return '1';
    } else {
      return '0';
    }
  }

  public int minOperations(String s) {
    char currentA = '0';
    char currentB = '1';
    int opA = 0;
    int opB = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == currentA) {
        opA++;
        currentA = change(s.charAt(i));
      } else {
        currentA = s.charAt(i);
      }

      if (s.charAt(i) == currentB) {
        opB++;
        currentB = change(s.charAt(i));
      } else {
        currentB = s.charAt(i);
      }
    }
    return Math.min(opA, opB);
  }

  public static void main(String[] args) {
    MinimumChangesToMakeAlternatingBinaryString solution = new MinimumChangesToMakeAlternatingBinaryString();
    System.out.println(solution.minOperations("1111"));
  }
}

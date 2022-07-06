package org.example.RWTH.R20220627_String;

public class LongestNiceSubstring {
  public String longestNiceSubstring(String s) {
    int lower = 0;
    int upper = 0;

    int begin = 0;
    int len = 0;
    for (int i = 0; i < s.length(); i++) {
      lower = 0;
      upper = 0;
      for (int j = i; j < s.length(); j++) {
        if (Character.isLowerCase(s.charAt(j))) {
          lower |= 1 << s.charAt(j) - 'a';
        } else {
          upper |= 1 << s.charAt(j) - 'A';
        }
        if (lower == upper && (j - i + 1 > len)) {
          len = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + len);
  }

  public static void main(String[] args) {
    String s = "c";
    LongestNiceSubstring solution = new LongestNiceSubstring();
    System.out.println(solution.longestNiceSubstring(s));
  }
}

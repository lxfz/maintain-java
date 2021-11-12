package org.example.leetcode;

public class S0091 {
  public int numDecodings(String s) {
    int a = 0; // f[i-2]
    int b = 0; // f[i-1]
    int c = 0; // f[i]
    int i = 0;
    while(i < s.length() && s.charAt(i) == '0' ) i++;
    if(i!=0) return 0;
    if(i == s.length()) return 0;
    if(i == s.length() - 1) return 1;
    a = 1;
    if(s.charAt(i+1) == '0') {
      b = 1;
    } else if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')) {
      b = 2;
    } else {
      b = 1;
    }
    c = b;
    i += 2;
    while(i<s.length()) {
      if(s.charAt(i) == '0' && s.charAt(i-1) == '0') return 0;
      if(s.charAt(i) == '0') {
        if(s.charAt(i-1) > '2') return 0;
        c = a;
      } else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
        c = a + b;
      } else {
        c = b;
      }
      a = b;
      b = c;
      i++;
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println(new S0091().numDecodings("230"));
  }
}

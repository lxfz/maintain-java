package org.example.RWTH.R20220627_String;

public class ValidPalindromeII {
  public boolean isPalindrome(String s, int i, int j) {
    for (; i < j && s.charAt(i) == s.charAt(j); i++, j--) ;
    return i >= j;
  }

  public boolean validPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    for (; i < j && s.charAt(i) == s.charAt(j); i++, j--) ;
    return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
  }
}

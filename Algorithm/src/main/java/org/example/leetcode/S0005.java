package org.example.leetcode;

public class S0005 {

  public String longestPalindrome_01(String s) {
     String result = "";
     int k = 0;
     for(int i=0; i<s.length(); i++) {
       k = 1;
       while(i-k>=0 && i+k <s.length() && s.charAt(i-k) == s.charAt(i+k)) k++;
       if(2*(k-1) + 1 > result.length()) {
         result = s.substring(i-k+1, i+k);
       }
       k=0;
       while(i-k>=0 && i+k+1 < s.length() && s.charAt(i-k) == s.charAt(i+k+1)) k++;
       if(2*k > result.length()) {
         result = s.substring(i-k+1, i+k+1);
       }
     }
     return result;
  }

  public String longestPalindrome(String s) {
    int start=0, end=0, len=0;
    int k = 0;
    for(int i=0; i<s.length(); i++) {
      k = 1;
      while(i-k>=0 && i+k <s.length() && s.charAt(i-k) == s.charAt(i+k)) k++;
      if(2*(k-1) + 1 > len) {
        start = i-k+1;
        end = i+k;
        len = 2*(k-1) + 1;
      }
      k=0;
      while(i-k>=0 && i+k+1 < s.length() && s.charAt(i-k) == s.charAt(i+k+1)) k++;
      if(2*k > len) {
        start = i-k + 1;
        end = i+k+1;
        len = 2*k;
      }
    }
    return s.substring(start, end);
 }

  public static void main(String[] args) {
    System.out.println(new S0005().longestPalindrome("babad"));
  }
  
}
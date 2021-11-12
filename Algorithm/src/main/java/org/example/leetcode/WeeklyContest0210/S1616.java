package org.example.leetcode.WeeklyContest0210;

public class S1616 {

  public boolean checkPalindromeString(String s) {
    if(s.length() == 0) return true;
    int i = s.length() / 2 - 1;
    int j = 0;
    if(s.length() % 2 == 0) {
      j = s.length() / 2;
    } else {
      j = s.length() /2 + 1;
    }
    while(i >=0) {
      if(s.charAt(i) != s.charAt(j)) return false;
      i--;
      j++;
    }
    return true;
  }

  public boolean checkPrefix(String a, String b) {
    int i = 0;
    for(i=0; i<a.length()/2; i++) {
      if(a.charAt(i) == b.charAt(b.length()-1 - i)) {
      } else break;
    }
    // System.out.println(i + " " + (b.length() - i) );   
    if(checkPalindromeString(b.substring(i, b.length()-i)) ||
      checkPalindromeString(a.substring(i, a.length()-i))){
        return true;
    } 
    return false;
  }

  public boolean checkPalindromeFormation(String a, String b) {
    if(checkPalindromeString(a) && checkPalindromeString(b)) return true;
    if(checkPrefix(a, b) || checkPrefix(b, a)) return true;
    return false;
  }

  public static void main(String[] args) {
    String a="ulaxcfd",
    b="jicxalu";
    System.out.println(new S1616().checkPalindromeFormation(a, b));
    // System.out.println(new S1616().checkPalindromeString("fedef"));
  }
  
}

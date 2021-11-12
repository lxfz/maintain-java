package org.example.leetcode;

public class S0564 {

  public boolean check(String s) {
    if(s.length() == 0) return true;
    int i, j;
    if(s.length() % 2 == 1) {
      i = s.length() / 2;
      j = s.length() / 2;
    } else {
      i = s.length() / 2 - 1;
      j = s.length() / 2;
    }
    while(i>=0 && j< s.length()) {
      if(s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i--;
      j++;
    }
    return true;
  }

  public String nearestPalindromic_1(String n) {
    int i, j;
    char[] news = n.toCharArray();
    char[] news2 = news.clone();
    char[] news3 = news.clone();

    if(n.length() % 2 ==1) {
      i = n.length() / 2;
      j = n.length() / 2;

    } else {
      i = n.length() / 2 -1;
      j = n.length() / 2;
    }
    news2[i] = news2[i] == '9' ? '0' : (char)((int)news2[i] + 1);
    news3[i] = news3[i] == '0' ? '9' : (char)((int)news3[i] - 1);

    while(i>=0 && j<n.length()) {
      news[j] = news[i];
      news2[j] = news2[i];
      news3[j] = news3[i];
      i--;
      j++;
    }

    long a = Math.abs(Long.valueOf(String.valueOf(news)) - Long.valueOf(n));
    long b = Math.abs(Long.valueOf(String.valueOf(news2)) - Long.valueOf(n));
    long c = Math.abs(Long.valueOf(String.valueOf(news3)) - Long.valueOf(n));

    System.out.println(a + " " + String.valueOf(news));
    System.out.println(b + " " + String.valueOf(news2));
    System.out.println(c + " " + String.valueOf(news3));

    if(check(n)) {
      if(b < c) {
        return String.valueOf(news2);
      } else {
        return String.valueOf(news3);
      }
    }

    if(a <= b) {
      if(a < c) {
        return String.valueOf(news);
      } else {
        return String.valueOf(news3);
      }
    } else if(b < c) {
      return String.valueOf(news2);
    } else {
      return String.valueOf(news3);
    }
        
  }

  public String nearestPalindromic_2(String n) {
    String s1 = nearestPalindromic_1(n);
    if(n.length() == 1) return s1;
    char[] c2 = new String(n.substring(1)).toCharArray();
    for(int i=0; i<c2.length; i++) {
      c2[i] = '9';
    }
    Long a = Math.abs(Long.valueOf(n) - Long.valueOf(s1));
    Long b = Math.abs(Long.valueOf(n) - Long.valueOf(String.valueOf(c2)));
    if(a < b) {
      return s1;
    } else {
      return String.valueOf(c2);
    }
  }

  public String nearestPalindromic(String n) {
    String s1 = nearestPalindromic_2(n);
    char[] c2 = new char[n.length()+1];
    for(int i=0; i<c2.length; i++) {
      c2[i] = '0';
    }
    c2[0] = '1';
    c2[n.length()] = '1';
    Long a = Math.abs(Long.valueOf(n) - Long.valueOf(s1));
    Long b = Math.abs(Long.valueOf(n) - Long.valueOf(String.valueOf(c2)));
    if(a < b) {
      return s1;
    } else {
      return String.valueOf(c2);
    }

  }

  public static void main(String[] args) {
    String n = 
    "1805170081";
    System.out.println(new S0564().nearestPalindromic(n));
  }
  
}

package org.example.leetcode;

public class S0010 {

  public boolean isMatch_01(String s, String p) {
    int i=0, j=0;
    char P;
    if(s=="" && p=="") return true;
    else if(s=="" || p=="") return false;
    // How about the p begins with '*'
    while(p.charAt(j)=='*') j++;
    if(p.charAt(j) == '.') P = '.';
    else P = p.charAt(j);
    while(i<s.length() && j<p.length()) {
      if (s.charAt(i) == p.charAt(j)) {
        P = p.charAt(j);
        i++; j++;
      } else if(p.charAt(j) >= 'a' && p.charAt(j) <='z') {
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
          j++;
          while(j<p.length() && p.charAt(j) == '*') j++;
          if(j<p.length()) P = p.charAt(j);
        } else return false;
      } else if (p.charAt(j) == '.') {
        P = p.charAt(j);
        i++; j++;
      } else { // p=='*'
        if(P == s.charAt(i) || P == '.') i++;
        else j++;
      }
    }
    while(j< p.length() && p.charAt(j) == '*') j++;
    if(i == s.length() && j== p.length()) return true;
    else return false;
  }

  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();

    // if(m==0 && n==0) return true;
    // else if (m==0 || n == 0) return false;

    boolean[][] f = new boolean[m+1][n+1];
    f[0][0] = true;
    for(int i=1; i<m+1; i++) f[i][0] = false;
    for(int i=1; i<n+1; i++) {
      if(p.charAt(i-1) != '*')f[0][i] = false;
      else if(i>=2) f[0][i] = f[0][i-2];
    }
    

    int k = 0;
    for(int i=1; i<m+1; i++) 
      for(int j=1; j<n+1; j++) {
        if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') f[i][j] = f[i-1][j-1];
        else if(p.charAt(j-1) >= 'a' && p.charAt(j-1) <= 'z') f[i][j] = false;
        else if(p.charAt(j-1) == '*') {
          k = j-2;
          // while(k>0 && p.charAt(k-1) == '*') k--;
          // if(k==0) f[i][j] = true; // all * until now
          if (s.charAt(i-1) == p.charAt(k) || p.charAt(k) == '.') f[i][j] = f[i][j-2] 
          || f[i-1][j-1] || f[i][j-1] || f[i-1][j];
          else f[i][j] = f[i][j-2];
        }
      }
    System.out.printf("\t");
    for(int j=0; j<=n; j++) {
      System.out.printf("%d\t", j);
    }
    System.out.println();
    for(int i=0; i<=m; i++){
      System.out.print( i + "\t");
      for(int j=0; j<=n; j++) {
        System.out.print(f[i][j] + "\t");
      }
      System.out.println();
    }
    return f[m][n];
  }

  public static void main(String[] args) {
    String s = "adceb",
    p = "*a*b";
    System.out.println(new S0010().isMatch(s, p));
  }
  
}
package org.example.leetcode;

public class S0044 {

  public boolean isMatch(String s, String p) {
    boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
    
    for(int i=1; i<=s.length(); i++) f[i][0] = false;
    for(int i=1; i<=p.length(); i++) f[0][i] = false;
    f[0][0] = true;
    for(int i=1; i<=p.length() && p.charAt(i-1)=='*'; i++) f[0][i]=true;

    for(int i=1; i<=s.length(); i++) 
      for(int j=1; j<=p.length(); j++) {
        if(s.charAt(i-1) == p.charAt(j-1)) 
        f[i][j] = f[i-1][j-1];
        else {
          if(p.charAt(j-1) >= 'a' && p.charAt(j-1) <='z') f[i][j] = false;
          else if(p.charAt(j-1) == '?') f[i][j] = f[i-1][j-1];
          else if (p.charAt(j-1) == '*') f[i][j] = f[i][j-1] || f[i-1][j-1] || f[i-1][j];
        }
      }
      int m = s.length();
      int n = p.length();
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
    return f[s.length()][p.length()];
  }

  public static void main(String[] args) {
  
    String 
    s = "adceb",
    p = "*a*b";

    System.out.println(new S0044().isMatch(s, p));
    
  }
  
}
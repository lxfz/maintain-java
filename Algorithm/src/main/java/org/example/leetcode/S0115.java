package org.example.leetcode;

public class S0115 {

  public int numDistinct(String s, String t) {
    int[][] f = new int[s.length()+1][t.length()+1];
    
    for(int i=0; i<=s.length(); i++) {
      f[i][0] = 1;
    }
    for(int i=1; i<=s.length(); i++) {
      for(int j=1; j<=t.length(); j++) {
        f[i][j] = f[i-1][j];
        if(s.charAt(i-1) == t.charAt(j-1) ) f[i][j] += f[i-1][j-1];
      }
    }
    return f[s.length()][t.length()];    
  }

  public static void main(String[] args) {
    String S = "babgbag", T = "bag";
    System.out.println(new S0115().numDistinct(S, T));
  }
  
}

package org.example.leetcode;

public class S0097 {

  public boolean isInterleave_v1(String s1, String s2, String s3) {
    if(s3.length() != s1.length() + s2.length()) return false;
    boolean[][][] f = new boolean[s3.length() + 1][s1.length()+1][s2.length()+1];
    f[0][0][0] = true;

    for(int n = 1; n <= s3.length(); n++) {
      for(int i=0; i<=s1.length(); i++) {
        for(int j=0; j<=s2.length(); j++) {
          if(i>0)
            f[n][i][j] =f[n][i][j] || (f[n-1][i-1][j] && (s3.charAt(n-1) == s1.charAt(i-1)));
          if(j>0)
            f[n][i][j] = f[n][i][j] || (f[n-1][i][j-1] && (s3.charAt(n-1) == s2.charAt(j-1)));
        }
      }
    }
    return f[s3.length()][s1.length()][s2.length()];
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    if(s3.length() != s1.length() + s2.length()) return false;
    boolean[][] f = new boolean[s3.length()+1][s1.length()+1];
    f[0][0] = true;
    for(int n=1; n<=s3.length(); n++) {
      for(int i=0; i<=s1.length(); i++) {
        if(i>0)
          f[n][i] = f[n][i] || (f[n-1][i-1] && (s3.charAt(n-1)==s1.charAt(i-1)));
        if(n-i > 0 && n-i <=s2.length()) 
          f[n][i] = f[n][i] || (f[n-1][i] && (s3.charAt(n-1) == s2.charAt(n-i-1)));
      }
    }
    return f[s3.length()][s1.length()];
  }

  public static void main(String[] args) {
    String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
    System.out.println(new S0097().isInterleave(s1, s2, s3));
  }
  
}

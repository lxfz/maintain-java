package org.example.leetcode;

public class S0132 {

  public int minCut(String s) {
    int min = Integer.MAX_VALUE;
    int[][] f = new int[s.length()][s.length()];
    for(int len = 1; len <= s.length(); len++) {
      for(int i = 0; i < s.length(); i++) {
        int j = i + len - 1;
        if(j >= s.length()) break;

        if(s.charAt(i) == s.charAt(j) && (j-i<=2 || f[i+1][j-1] == 0)) {
            f[i][j] = 0;
        } else {
          min = Integer.MAX_VALUE;
          for(int k=i; k<j; k++) {
            min = Math.min(min, f[i][k] + f[k+1][j] + 1);
          }
          f[i][j] = min;
        }
      }
    }
    return f[0][s.length()-1];   
  }

  public int minCut_ref(String s) {
    char[] c = s.toCharArray();
    int n = c.length;
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];
    
    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = 0; j <= i; j++) {
            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;  
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
        }
        cut[i] = min;
    }
    return cut[n - 1];
}


  public static void main(String[] args) {
    String s = "cabababcbc";
    System.out.println(new S0132().minCut(s));
  }
  
}

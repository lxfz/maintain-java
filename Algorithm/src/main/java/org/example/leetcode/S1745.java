package org.example.leetcode;

public class S1745 {

  public boolean checkPartitioning(String s) {
    char[] c = s.toCharArray();
    boolean[][] pal = new boolean[c.length][c.length];
    
    for(int i=0; i<c.length; i++) {
      for(int j=0; j<=i; j++) {
        if(c[i] == c[j] && (i-j < 2 || pal[j+1][i-1])) {
          pal[j][i] = true;
        }
      }
    }

    for(int i=0; i<c.length-2; i++) {
      for(int j=i+2; j<c.length; j++) {
        if(pal[0][i] && pal[i+1][j-1] && pal[j][c.length-1]) return true;
      }
    }

    return false;
  }

}

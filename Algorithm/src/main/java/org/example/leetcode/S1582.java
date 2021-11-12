package org.example.leetcode;

public class S1582 {
  public int numSpecial(int[][] mat) {
    int count = 0;
    boolean flag = true;
    for(int i=0; i<mat.length; i++) {
      for(int j=0; j<mat[0].length; j++) {
        flag = true;
        if(mat[i][j] == 1) {
          for(int k=0; k<mat[0].length; k++) {
            if(k!=j && mat[i][k] == 1) flag = false;
          }
          for(int k=0; k<mat.length; k++) {
            if(k!=i && mat[k][j] == 1) flag = false;
          }
          if(flag) count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    
  }
}

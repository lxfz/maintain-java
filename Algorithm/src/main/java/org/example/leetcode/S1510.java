package org.example.leetcode;

public class S1510 {

  public boolean winnerSquareGame(int n) {
    boolean[] f = new boolean [n+1];
    f[0] = false;
    f[1] = true;

    for(int i=2; i<=n; i++) {
      for(int j=1; j*j <= i; j++){
        if(!f[i - j*j]) {
          f[i] = true;
          break;
        }
      }
    }
    return f[n];
  }

  public static void main(String[] args) {
    int n =17;
    System.out.println(new S1510().winnerSquareGame(n));    
  }
  
}
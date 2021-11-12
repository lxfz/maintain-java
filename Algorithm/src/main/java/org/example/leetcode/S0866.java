package org.example.leetcode;

public class S0866 {

  public boolean isPrime(int X) {
    if(X <= 3) return X > 1;
    else if (X % 2 == 0 || X % 3 == 0 ) return false;
    int i = 5;
    while(i * i <= X) {
      if(X % i == 0 || X % (i + 2) == 0 ) return false;
      i++;
    }
    return true;
  }

  public boolean isPalindrome(int N) {
    int reversedN = 0;
    int copyN = N;
    while(copyN > 0) {
      reversedN = reversedN * 10 + copyN % 10;
      copyN /= 10;
    }
     return N == reversedN;   
  }

  public int primePalindrome(int N) {
    while(true) {
      // System.out.println(N);
      if(isPalindrome(N) && isPrime(N)) return N;
      if(N >= 10_000_000 && N<100_000_000) N = 100_000_001;
      N++;
    }
  }

  public static void main(String[] args) {
    int N = 9989900;
    System.out.println(new S0866().primePalindrome(N));
  }
}

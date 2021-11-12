package org.example.leetcode;


public class S0902 {
  public String[] dgs;

  public int getLessThanNum(char c) {
    int lessThanNum = 0;
    for(int i=0; i<dgs.length; i++) {
      if(Integer.valueOf(dgs[i]) < (int)(c - '0')) lessThanNum++;
    }
    return lessThanNum;
  }

  public int getEqualNum(char c) {
    int equalNum = 0;
    for(int i=0; i<dgs.length; i++) {
      if(Integer.valueOf(dgs[i]) == (int)(c - '0')) equalNum++;
    }
    return equalNum;
  }

  public int atMostNGivenDigitSet(String[] digits, int n) {
    dgs = digits;

    String sn = Integer.toString(n);
    // f[cur][lim][zero]
    int[][][] f = new int[sn.length()][2][2];
    int cur = sn.length() - 1;
    f[cur][0][0] = digits.length;
    f[cur][0][1] = digits.length;
    int limNum = getLessThanNum(sn.charAt(sn.length()-1)) + getEqualNum(sn.charAt(sn.length()-1));

    f[cur][1][0] = limNum;
    f[cur][1][1] = limNum;
    int euqalNum = 0;

    for(cur = sn.length() - 2; cur >= 0; cur--) {
      limNum = getLessThanNum(sn.charAt(cur)); // lessThanNum
      euqalNum = getEqualNum(sn.charAt(cur));
      f[cur][0][0] = digits.length * f[cur+1][0][1] + f[cur+1][0][0];
      f[cur][0][1] = digits.length * f[cur+1][0][1];
      f[cur][1][0] = limNum * f[cur+1][0][1] + f[cur+1][0][0] + euqalNum * f[cur+1][1][1];
      f[cur][1][1] = limNum * f[cur+1][0][1] + euqalNum * f[cur+1][1][1];
    }
    return f[0][1][0];
  }

  public static void main(String[] args) {
    String[] digits = {"7"};
    int n = 8;
    System.out.println(new S0902().atMostNGivenDigitSet(digits, n));
  }
  
}

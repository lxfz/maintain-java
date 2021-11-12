package org.example.leetcode;

public class S1513 {

  public int numSub(String s) {
    int len = s.length();
    int total = 0;
    int sublen = 0;
    int m = 1000000007;
    int[] f = new int[len+1];
    f[0] = 0; f[1] = 1;
    for(int i=2; i<len+1; i++) {
      f[i] = (i + f[i-1]) % m;
    }

    int i=0;
    while(i<len) {
      if(s.charAt(i)=='1') {
        sublen = 0;
        while(i<len && s.charAt(i) == '1') {
          sublen++;
          i++;
        }
        total = (total + f[sublen]) % m;
      }else i++;
    }
    return total;
  }

  public static void main(String[] args) {
    String s = "000";
    System.out.println(new S1513().numSub(s));
  }
  
}
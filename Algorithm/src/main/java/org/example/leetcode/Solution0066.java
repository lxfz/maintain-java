package org.example.leetcode;

public class Solution0066 {
  
  public int[] plusOne(int[] digits) {
    int c = 1;
    int result[];
    for(int i = digits.length-1; i>=0 && c>0; i--) {
      digits[i] += c;
      c = digits[i] / 10;
      digits[i] = digits[i] % 10;
    }
    if (c==0) result = digits;
    else {
      result = new int[digits.length + 1];
      result[0] = c;
      for (int i=1; i<result.length; i++) result[i] = digits[i-1];
    }
    return result;
   }


  public static void main(String[] args) {
    int result[] = new Solution0066().plusOne(new int[]{0});
    for (int i=0; i<result.length; i++){
      System.out.print(result[i]);
      System.out.print(" ");
    } 
  }

}
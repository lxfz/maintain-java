package org.example.RWTH.R20220509_BitManipunation;

public class ReverseBits {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int res = 0;
    for(int i=0; i<32; i++) {
      res <<= 1;
      res |= n & 1;
      n >>>=1;
    }
    return res;
  }

  public static void main(String[] args) {
    ReverseBits reverseBits = new ReverseBits();
    System.out.println(Integer.toBinaryString(reverseBits.reverseBits(-3)));
  }
}

package org.example.RWTH.R20220509_BitManipunation;

public class HammingDistance {
  public int hammingDistance(int x, int y) {
    int z = x ^ y;
    int res = 0;
    while (z != 0) {
      if ((z & 1) == 1) {
        res += 1;
      }
      z >>= 1;
    }
    return res;
  }

  public static void main(String[] args) {
    HammingDistance hd = new HammingDistance();
    System.out.println(hd.hammingDistance(3, 1));
    System.out.println(Integer.toBinaryString(-3));
  }
}

package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A1431 {

  static class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
      int max = 0;
      List<Boolean> res = new ArrayList<>();
      for(int x : candies) {
        if(x>max) max = x;
      }
      for(int x: candies) {
        if(x + extraCandies >= max)
          res.add(true);
        else
          res.add(false);
      }
      return res;
    }
  }

  public static void main(String[] args) {
    
  }
  
}
package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0119 {
  public List<Integer> getRow(int rowIndex) {
     int[] oldRow = new int[rowIndex+1];
     int[] newRow = new int[rowIndex+1];
     int[] tempRow;
     oldRow[0] = 1;
     for(int i=1; i<=rowIndex; i++) {
      newRow[0] = 1;
      for(int j=1; j<i; j++) {
        newRow[j] = oldRow[j-1] + oldRow[j];
      }
      newRow[i] = 1;
      tempRow = oldRow;
      oldRow = newRow;
      newRow = tempRow;
     }
     List<Integer> ans = new ArrayList<>();
     for(int x : oldRow){
       ans.add(x);
     }
    return ans;
  }

  public List<Integer> getRow_best(int rowIndex) {
    Integer[] result =  new Integer[rowIndex + 1];
    Arrays.fill(result, 0);
    result[0] = 1;
    for(int i = 1; i < rowIndex + 1; i++)
      for(int j = i; j >= 1; j--)
        result[j] += result[j - 1];
    return Arrays.asList(result);
  }
}

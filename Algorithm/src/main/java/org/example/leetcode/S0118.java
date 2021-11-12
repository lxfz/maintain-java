package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S0118 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    row.add(1);
    result.add(row);
    for(int i=1; i<numRows; i++) {
      List<Integer> r = new ArrayList<>();
      r.add(1);
      for(int j=1; j<result.get(i-1).size(); j++) {
        r.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
      }
      r.add(1);
      result.add(r);
    }
    return result;
  }
}

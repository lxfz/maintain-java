package org.example.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    List<Integer> pre = null;
    cur.add(1);
    ans.add(cur);

    for (int i = 1; i < numRows; i++) {
      cur = new ArrayList<>();
      cur.add(1);
      pre = ans.get(i - 1);
      for (int j = 0; j < pre.size() - 1; j++) {
        cur.add(pre.get(j) + pre.get(j + 1));
      }
      cur.add(1);
      ans.add(cur);
    }
    return ans;
  }

  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> rows = generate(rowIndex + 1);
    return rows.get(rowIndex);
  }
}

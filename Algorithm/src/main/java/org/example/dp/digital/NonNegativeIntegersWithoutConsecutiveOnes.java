package org.example.dp.digital;

public class NonNegativeIntegersWithoutConsecutiveOnes {


  private int dfs(int pos, boolean lim, boolean zero, int pre) {

    int res = 0;
    if (pos < 0) return 1;
    if (pre == 1) {
      res += dfs(pos - 1, lim, zero, 0);
    } else {
      res += dfs(pos - 1, lim, zero, 0);
      res += dfs(pos - 1, lim, zero, 1);
    }
    return res;
  }

  public int findIntegers(int n) {
    return 0;
  }

}

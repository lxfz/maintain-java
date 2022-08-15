package org.example.dp.digital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersAtMostNGivenDigitSet {

  int[] possibleDigits;
  List<Integer> upperBounds = new ArrayList<>();
  int[][][] dp; // dp[pos][lim][zero]

  private int dfs(int pos, boolean lim, boolean zero) {
    /**
     * pos : 当前位置
     * lim : 前面的位置是否贴者填
     * zero : 前面是否都为 0
     */
    int ret = 0;
    int int_lim = lim ? 1 : 0;
    int int_zero = zero ? 1 : 0;

    // 如果已经枚举完每一位，直接返回 1
    if (pos < 0) return 1;

    // 如果已经计算过了，直接返回记录值
    if (dp[pos][int_lim][int_zero] != -1) return dp[pos][int_lim][int_zero];

    for (int i = 0; i < possibleDigits.length; i++) {

      // 即 possibleDigits[i] 可以放在当前位置
      if (!lim || possibleDigits[i] <= upperBounds.get(pos)) {
        ret += dfs(pos - 1, lim && (possibleDigits[i] == upperBounds.get(pos)), false);
      }
    }

    // fill with 0
    if (pos > 0 && zero) {
      ret += dfs(pos - 1, false, true);
    }
    dp[pos][int_lim][int_zero] = ret;
    return ret;
  }

  public int atMostNGivenDigitSet(String[] digits, int n) {
    while (n > 0) {
      upperBounds.add(n % 10);
      n /= 10;
    }

    possibleDigits = new int[digits.length];
    dp = new int[upperBounds.size()][2][2];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i][0], -1);
      Arrays.fill(dp[i][1], -1);
    }
    for (int i = 0; i < digits.length; i++) {

      possibleDigits[i] = Integer.parseInt(digits[i]);
    }
    return dfs(upperBounds.size() - 1, true, true);
  }

  public static void main(String[] args) {
    NumbersAtMostNGivenDigitSet solution = new NumbersAtMostNGivenDigitSet();
    String[] digits = {"7"};
    int n = 8;
    System.out.println(solution.atMostNGivenDigitSet(digits, n));
  }

}

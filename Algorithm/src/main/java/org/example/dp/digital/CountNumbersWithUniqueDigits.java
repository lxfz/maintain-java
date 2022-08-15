package org.example.dp.digital;

public class CountNumbersWithUniqueDigits {

  private int search(int pos, int mask) {
    /**
     * pos 这个位置可以填0-9 的所有可能结果
     */
    int res = 0;
    if (pos < 0) return 1;

    for (int i = 0; i <= 9; i++) {
      if (((mask >> i) & 1) == 1) {
        continue;
      }
      mask |= (1 << i);
      res += search(pos - 1, mask);
      mask ^= 1 << i;
    }
    return res;
  }

  public int countNumbersWithUniqueDigits(int n) {
    if(n==0) return 1;
    int ans = 0;
    int mask = 0;
    for(int i=0; i<n; i++) {  // 长度为 i+1
      /**
       * 分类讨论，长度为i+1时，所有可能的数字
       */
      for(int j=1; j<=9; j++) {
        mask = 1 << j;
        ans += search(i-1, mask);
      }
    }
    return ans + 1; // with 0
  }

  public static void main(String[] args) {
    CountNumbersWithUniqueDigits solution = new CountNumbersWithUniqueDigits();
    System.out.println(solution.countNumbersWithUniqueDigits(2));
  }
}

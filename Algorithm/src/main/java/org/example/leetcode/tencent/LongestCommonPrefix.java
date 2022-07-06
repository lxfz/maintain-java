package org.example.leetcode.tencent;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    StringBuilder ans = new StringBuilder();
    int index = -1;
    boolean isCommonPre;
    char commonPre;
    while (true) {
      index++;
      isCommonPre = true;
      if (index >= strs[0].length()) {
        break;
      } else {
        commonPre = strs[0].charAt(index);
      }
      for (int i = 1; i < strs.length; i++) {
        if (index >= strs[i].length() || strs[i].charAt(index) != commonPre) {
          isCommonPre = false;
          break;
        }
      }
      if (isCommonPre) {
        ans.append(commonPre);
      } else {
        break;
      }
    }
    return ans.toString();
  }
}

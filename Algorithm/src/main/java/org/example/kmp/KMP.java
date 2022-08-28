package org.example.kmp;

public class KMP {

  /**
 * 构造前缀表
   *
   * @param pattern 匹配的字符串
   * @param prefix  prefix table
   * @param n       length of the array
   */
  public static void prefix_table(char[] pattern, int[] prefix, int n) {
    prefix[0] = 0;
    int j;

    for (int i = 1; i < n; i++) {
      j = prefix[i - 1];
      while (j > 0 && pattern[i] != pattern[j]) {
        j = prefix[j - 1];
      }

      if (pattern[i] == pattern[j]) {
        j += 1;
      }

      prefix[i] = j;
    }

//    int len = 0; // 0 -> i-1 这个字符串的 最长公共前后缀 的长度
//    int i = 1;
//
//    while (i < n) {
//      if (pattern[i] == pattern[len]) {
//        len++;
//        prefix[i++] = len;
//      } else {
//        if (len > 0) {
//          len = prefix[len - 1];
//        } else {
//          prefix[i] = 0;
//          i++;
//        }
//      }
//    }
  }

  public static void move_prefix(int[] prefix, int n) {
    for (int i = n - 1; i > 0; i--) {
      prefix[i] = prefix[i - 1];
    }
    prefix[0] = -1;
  }

  public static void kmp_search(char[] text, char[] pattern) {
    int n = pattern.length;
    int m = text.length;

    int[] prefix = new int[n];
    prefix_table(pattern, prefix, n);
    move_prefix(prefix, n);

    // text[i], len(text) = m
    // pattern[j], len(pattern) = n
    int i = 0;
    int j = 0;
    while (i < m) {  // 0
      if (j == n - 1 && text[i] == pattern[j]) { // 找到
        System.out.println("Found pattern at: " + (i - j)); //
        j = prefix[j];
      }

      if (text[i] == pattern[j]) {  // 1
        i++;
        j++;
      } else {  // 2
        j = prefix[j];
        if (j == -1) {
          i++;
          j++; // j=0
        }
      }
    }
  }

  public static void main(String[] args) {
    char[] pattern = "ABABCABAA".toCharArray();
    char[] text = "CABABABCABAABDABABABCABAASD".toCharArray();

    kmp_search(text, pattern);

//    int n = pattern.length;
//    int[] prefix = new int[n];
//
//    prefix_table(pattern, prefix, n);
//    move_prefix(prefix, n);
//    for (int i = 0; i < n; i++) {
//      System.out.println(prefix[i]);
//    }
  }

}

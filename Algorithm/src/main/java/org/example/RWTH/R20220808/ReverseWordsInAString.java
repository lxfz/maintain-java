package org.example.RWTH.R20220808;

public class ReverseWordsInAString {

  public String reverseWords(String s) {
    char[] str = s.toCharArray();
    reverse(str, 0, str.length - 1);
    reverseWord(str);
    return cleanSpace(str);
  }


  public String cleanSpace(char[] s) {
    int i = 0, j = 0;
    while (j < s.length) {
      while (j < s.length && s[j] == ' ') j++; // skip spaces
      while (j < s.length && s[j] != ' ') s[i++] = s[j++]; // keep non spaces

      while (j < s.length && s[j] == ' ') j++; // skip spaces
      if (j < s.length) s[i++] = ' ';
    }
    return new String(s).substring(0, i);
  }

  public void reverseWord(char[] s) {
    int i = 0, j = 0;
    while (i < s.length) {
      while (j < s.length && s[j] == ' ') j++;
      i = j;
      while (j < s.length && s[j] != ' ') j++;
      reverse(s, i, j - 1);
    }
  }

  public void reverse(char[] s, int i, int j) {
    while (i < j) {
      char c = s[j];
      s[j--] = s[i];
      s[i++] = c;
    }
  }
}

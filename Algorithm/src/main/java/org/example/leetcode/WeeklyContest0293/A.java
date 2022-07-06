package org.example.leetcode.WeeklyContest0293;

import java.util.ArrayList;
import java.util.List;

public class A {

  public boolean compare(String x, String y) {
    int[] a = new int[26];
    for (char c : x.toCharArray()) {
      a[c - 'a']++;
    }
    for (char c : y.toCharArray()) {
      a[c - 'a']--;
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public List<String> removeAnagrams(String[] words) {
    List<String> res = new ArrayList<>();
    String pre = words[0];
    res.add(words[0]);
    for (String word : words) {
      if (!compare(pre, word)) {
        res.add(word);
        pre = word;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    A a = new A();
    String[] words = {"a","b","c","d","e"};
    for(String word : a.removeAnagrams(words)){
      System.out.println(word);
    }
  }
}

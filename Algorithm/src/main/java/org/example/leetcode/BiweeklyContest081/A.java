package org.example.leetcode.BiweeklyContest081;

public class A {
  public int countAsterisks(String s) {
    char[] arr = s.toCharArray();
    int ans = 0;
    boolean count = true;
    for(int i=0; i<arr.length; i++) {
      if(arr[i] == '*' && count) {
        ans++;
      }
      if(arr[i] == '|') {
        count = !count;
      }
    }
    return ans;
  }

  public static void main(String[] args) {

  }
}

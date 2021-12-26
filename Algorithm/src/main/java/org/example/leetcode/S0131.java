//package org.example.leetcode;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class S0131 {
//  private List<List<String>> ans = new ArrayList<>();
//
//  public boolean checkPalindrome(String s, int left, int right) {
//    while(left <= right) {
//      if(s.charAt(left) != s.charAt(right)) return false;
//      left++;
//      right--;
//    }
//    return true;
//  }
//
//  public void backtrack(String s, int p, Stack<String> tempAns) {
//    if(p == s.length()) {
//      List<String> partition = new ArrayList<>(tempAns);
//      ans.add(partition);
//    }
//    for(int i=p; i<s.length(); i++) {
//      if(checkPalindrome(s, p, i)) {
//        tempAns.push(s.substring(p, i+1));
//        backtrack(s, i+1, tempAns);
//        tempAns.pop();
//      }
//    }
//  }
//
//  public List<List<String>> partition(String s) {
//     backtrack(s, 0, new Stack<>());
//     return ans;
//  }
//  public static void main(String[] args) {
//    S0131 s = new S0131();
//    String x = "aaba";
//    System.out.println(s.partition(x));
//  }
//}

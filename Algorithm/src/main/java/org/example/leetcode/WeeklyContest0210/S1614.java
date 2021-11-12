package org.example.leetcode.WeeklyContest0210;

import java.util.Stack;

public class S1614 {
  public int maxDepth(String s) {
    int ans = 0;
    Stack<Character> st = new Stack<>();
    for(int i=0; i<s.length(); i++) {
      if(s.charAt(i) == '(' || s.charAt(i) == ')') {
        st.push(s.charAt(i));
      }
    }
    int tempMax = 0;
    char c;
    while(!st.empty()) {
      c = st.pop();
      if(c == ')') {
        tempMax++;
        ans = Math.max(ans, tempMax);
      } else {
        tempMax--;
      }
    }
    return ans;
  }

   public static void main(String[] args) {
    String s = "1+(2*3)/(2-1)";
    System.out.println(new S1614().maxDepth(s));
  }
}

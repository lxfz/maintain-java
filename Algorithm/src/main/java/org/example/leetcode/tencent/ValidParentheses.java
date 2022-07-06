package org.example.leetcode.tencent;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.addLast(c);
      } else {
        Character d = stack.pollLast();
        if (d == null) {
          return false;
        }
        if (!((d == '(' && c == ')') || (d == '[' && c == ']') || (d == '{' && c == '}'))) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

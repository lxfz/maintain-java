package org.example.RWTH.R20220711_Stacks;

import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) return false;
        char topChar = stack.pop();
        if (c == '}' && topChar != '{') return false;
        if (c == ']' && topChar != '[') return false;
        if (c == ')' && topChar != '(') return false;
      }
    }
    return stack.isEmpty();
  }

}

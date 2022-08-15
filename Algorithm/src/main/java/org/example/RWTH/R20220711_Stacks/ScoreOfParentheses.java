package org.example.RWTH.R20220711_Stacks;

import java.util.Stack;

public class ScoreOfParentheses {

  public int scoreOfParentheses(String s) {
    Stack<Integer> resStack = new Stack<>();
    resStack.push(0);
    for (char c : s.toCharArray()) {
      if (c == '(') {
        resStack.push(0);
      } else {
        int topFirst = resStack.pop();
        int topSecond = resStack.pop();
        if (topFirst == 0) {
          topSecond += 1;
        } else {
          topSecond += 2 * topFirst;
        }
        resStack.push(topSecond);
      }
    }
    return resStack.peek();
  }

}

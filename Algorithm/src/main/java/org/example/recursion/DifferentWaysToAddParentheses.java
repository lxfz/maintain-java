package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

  public List<Integer> diffWaysToCompute(String expression, int begin, int end) {
    List<Integer> res = new ArrayList<>();
    if (end - begin == 0 || end - begin == 1) {
      res.add(Integer.parseInt(expression.substring(begin, end + 1)));
      return res;
    }
    for (int i = begin; i <= end; i++) {
      char c = expression.charAt(i);
      if (c == '+' || c == '-' || c == '*') {
        List<Integer> left = diffWaysToCompute(expression, begin, i - 1);
        List<Integer> right = diffWaysToCompute(expression, i + 1, end);
        for (int a : left) {
          for (int b : right) {
            if (c == '+') {
              res.add(a + b);
            } else if (c == '-') {
              res.add(a - b);
            } else {
              res.add(a * b);
            }
          }
        }
      }
    }
    return res;
  }

  public List<Integer> diffWaysToCompute(String expression) {
    return diffWaysToCompute(expression, 0, expression.length() - 1);
  }

  public static void main(String[] args) {
    DifferentWaysToAddParentheses solution = new DifferentWaysToAddParentheses();
    String expression = "2*3-4*5";
    System.out.println(solution.diffWaysToCompute(expression));
  }
}

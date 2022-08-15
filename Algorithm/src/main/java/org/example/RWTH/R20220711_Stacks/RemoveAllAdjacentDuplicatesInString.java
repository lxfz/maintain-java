package org.example.RWTH.R20220711_Stacks;

import java.util.Arrays;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
  public String removeDuplicates(String s) {
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char c : chars) {
      if (!stack.isEmpty() && c == stack.peek()) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (Object c : stack.toArray()) {
      stringBuilder.append(c);
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    String s = "abbaca";
    RemoveAllAdjacentDuplicatesInString solution = new RemoveAllAdjacentDuplicatesInString();
    System.out.println(solution.removeDuplicates(s));
  }

}

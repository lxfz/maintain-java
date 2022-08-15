package org.example.RWTH.R20220711_Stacks;

import java.util.Stack;

class MyQueue {

  Stack<Integer> firstStack = new Stack<>();
  Stack<Integer> secondStack = new Stack<>();

  public MyQueue() {

  }

  public void push(int x) {
    firstStack.push(x);
  }

  public int pop() {
    if (secondStack.isEmpty()) {
      while (!firstStack.isEmpty()) {
        secondStack.push(firstStack.pop());
      }
    }
    return secondStack.pop();
  }

  public int peek() {
    if (secondStack.isEmpty()) {
      while (!firstStack.isEmpty()) {
        secondStack.push(firstStack.pop());
      }
    }
    return secondStack.peek();
  }

  public boolean empty() {
    return firstStack.isEmpty() && secondStack.isEmpty();
  }
}

public class ImplementQueueUsingStacks {
}

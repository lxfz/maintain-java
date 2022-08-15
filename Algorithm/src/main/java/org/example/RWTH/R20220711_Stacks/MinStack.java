package org.example.RWTH.R20220711_Stacks;

import java.util.PriorityQueue;
import java.util.Stack;

class Node {
  public int val;
  public int min;

  public Node(int val, int min) {
    this.val = val;
    this.min = min;
  }
}

class MinStack {

  private Stack<Node> s = new Stack<>();
  private int currentMin = Integer.MAX_VALUE;

  public MinStack() {

  }

  public void push(int val) {
    if (val < currentMin) {
      currentMin = val;
    }
    Node node = new Node(val, currentMin);
    s.push(node);
  }

  public void pop() {
    s.pop();
    if (!s.isEmpty()) {
      Node node = s.peek();
      currentMin = node.min;
    } else {
      currentMin = Integer.MAX_VALUE;
    }
  }

  public int top() {
    Node node = s.peek();
    return node.val;
  }

  public int getMin() {
    Node node = s.peek();
    return node.min;
  }
}



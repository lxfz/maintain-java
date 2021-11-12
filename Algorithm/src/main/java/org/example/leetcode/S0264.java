package org.example.leetcode;

import java.util.Set;

import javafx.scene.layout.Priority;

import java.util.HashSet;
import java.util.PriorityQueue;
public class S0264 {

  public int nthUglyNumber(int n) {
    PriorityQueue<Long> queue = new PriorityQueue<>();
    queue.add(1L);
    long top = 0;
    for(int i=1; i<n; i++) {
      top = queue.poll();
      while(!queue.isEmpty() && queue.peek() == top) queue.poll();
      queue.add(top * 2);
      queue.add(top * 3);
      queue.add(top * 5);
    }
    return queue.peek().intValue();
  }
  public static void main(String[] args) {
    S0264 s = new S0264();
    System.out.println(s.nthUglyNumber(1352));
  }
}

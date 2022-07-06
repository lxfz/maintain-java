package org.example.vivo2021;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class TopSort {


  public String compileSeq(String input) {
    // write code here
    String[] values = input.split(",");
    int[] nums = new int[values.length];
    int[] inDeg = new int[values.length];
    int[][] graph = new int[values.length][values.length];
    String[] res = new String[values.length];

    for (int i = 0; i < values.length; i++) {
      nums[i] = Integer.parseInt(values[i]);
      if (nums[i] != -1){
        graph[nums[i]][i] = 1;
        inDeg[i]++;
      }
    }

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int i = 0; i < inDeg.length; i++) {
      if (inDeg[i] == 0) {
        priorityQueue.offer(i);
      }
    }
    int top = 0;
    int idx = 0;
    while (!priorityQueue.isEmpty()) {
      top = priorityQueue.poll();
      res[idx++] = Integer.toString(top);
      for (int i = 0; i < values.length; i++) {
        if (graph[top][i] > 0) {
          if (--inDeg[i] == 0) {
            priorityQueue.offer(i);
          }
        }
      }
    }
    return String.join(",", res);
  }

  public static void main(String[] args) {
    String input = "1,2,-1,1";
    System.out.println(new TopSort().compileSeq(input));
  }
}

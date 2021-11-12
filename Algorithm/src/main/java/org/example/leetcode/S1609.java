package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class S1609 {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public boolean isEvenOddTree(TreeNode root) {
    Queue<TreeNode> evenLevelQueue = new LinkedList<>();
    Queue<TreeNode> oddLevelQueue = new LinkedList<>();
    int evenLevelPreNum = 0;
    int oddLevelPreNum = 0;
    TreeNode evenLevelNode;
    TreeNode oddLevelNode;
    evenLevelQueue.add(root);
    while(!evenLevelQueue.isEmpty() || !oddLevelQueue.isEmpty()) {
      evenLevelPreNum = 0;
      oddLevelPreNum = Integer.MAX_VALUE;

      while(!evenLevelQueue.isEmpty()) {
        evenLevelNode = evenLevelQueue.poll();
        if(evenLevelNode.val % 2 == 0 || evenLevelNode.val < evenLevelPreNum) {
          return false;
        } else {
          evenLevelPreNum = evenLevelNode.val;
          if(evenLevelNode.left != null) {
            oddLevelQueue.add(evenLevelNode.left);
          }
          if(evenLevelNode.right != null) {
            oddLevelQueue.add(evenLevelNode.right);
          }
        }
      }

      while(!oddLevelQueue.isEmpty()) {
        oddLevelNode = oddLevelQueue.poll();
        if (oddLevelNode.val % 2 == 1 || oddLevelNode.val > oddLevelPreNum) {
          return false;
        } else {
          oddLevelPreNum = oddLevelNode.val;
          if(oddLevelNode.left != null) {
            evenLevelQueue.add(oddLevelNode.left);
          }
          if(oddLevelNode.right != null) {
            evenLevelQueue.add(oddLevelNode.right);
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(Math.atan2(-1, 0));
  }
  
}

package org.example.leetcode.maths;

public class PermutationSequence {

  private int count = 0;
  private String ans;
  private int K;

  public void backtrack(StringBuilder current, int i, boolean[] visited) {
    current.append((char)(i + '0'));
    visited[i] = true;
    if(current.length() == visited.length-1) {
      count++;
      System.out.println(current);

      if(count == K) {
        this.ans = current.toString();
      }
    } else {
      for(int j=1; j<visited.length; j++) {
        if(!visited[j] && this.ans == null) {
          backtrack(current, j, visited);
        }
      }
    }
    current.deleteCharAt(current.length()-1);
    visited[i] = false;
  }

  public String getPermutation(int n, int k) {
    boolean[] visited = new boolean[n+1];
    this.K = k;
    StringBuilder current = new StringBuilder();
    for(int i=1; i<=n; i++) {
      if(this.ans == null) {
        backtrack(current, i, visited);
      } else {
        break;
      }
    }
    return this.ans;
  }

  public static void main(String[] args) {
    PermutationSequence permutationSequence = new PermutationSequence();
    System.out.println(permutationSequence.getPermutation(4, 9));
  }
}

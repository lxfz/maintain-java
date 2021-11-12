package org.example.leetcode;

import java.util.Stack;

public class S0032 {

  public int longestValidParentheses_01(String s) {
    if(s.length() == 0) return 0;
    int[] f = new int[s.length()];
    int[] g = new int[s.length()];
    f[0] = 0; g[0] = 0;
    Stack<Integer> stack = new Stack<>();
    int k;
    for(int i=1; i<s.length(); i++) {
      if (s.charAt(i) == '(') f[i] = f[i-1];
      else { // s[i] = ')'
        k = i;
        stack.clear();
        while(k>=0) {
          if(s.charAt(k) == ')') stack.push(k);
          else if(!stack.empty()) stack.pop();
          else break;
          k--;
        }
        while(!stack.empty()) k = stack.pop();
        f[i] = Math.max(i-k, f[i-1]);
      }
    }
    return f[s.length()-1];
  }

  public int longestValidParentheses(String s) {
    if(s.length() == 0) return 0;
    int[] g = new int[s.length()];
    g[0] = 0;
    int k, max = 0;
    int unmatch = 0;
    int match_num = 0;
    for(int i=1; i<s.length(); i++) {
      if (s.charAt(i) == '(') {
        g[i] = 0;
      } 
      else { // s[i] = ')'
        k = i-1;
        unmatch = 1;
        match_num = 0;
        while(k>=0) {
          if(s.charAt(k) == ')') unmatch++;
          else {
            unmatch--;
            match_num+=2;
          }
          if(unmatch == 0) break;
          k--;
        }
        if(unmatch == 0) g[i] = match_num + (k-1>=0?g[k-1]:0);
        else g[i] = 0;
      }
      if(g[i] > max) max = g[i];
    }
    // for(int i=0; i<s.length(); i++) {
    //   System.out.printf("%d\t%d\t%d\n", i, g[i], f[i]);
    // }

    return max;
  }

  public int longestValidParentheses_02(String s) {
    if(s.length() == 0) return 0;
    int[] f = new int[s.length()];
    int[] g = new int[s.length()];
    f[0] = 0; g[0] = 0;
    Stack<Integer> stack = new Stack<>();
    int k;
    for(int i=1; i<s.length(); i++) {
      if (s.charAt(i) == '(') {
        f[i] = f[i-1]; g[i] = 0;
      } 
      else { // s[i] = ')'
        k = i;
        stack.clear();
        stack.push(k--);
        while(k>=0) {
          if(s.charAt(k) == ')') stack.push(k);
          else if(!stack.empty()){
            stack.pop();
            if(stack.empty()) break;
          }
          k--;
        }
        if(stack.empty()) {
          g[i] = i - k+1 + (k-1>=0?g[k-1]:0);
          f[i] = Math.max(g[i], f[i-1]);
        } else {
          g[i] = 0;
          f[i] = f[i-1];
        }
      }
    }
    // for(int i=0; i<s.length(); i++) {
    //   System.out.printf("%d\t%d\t%d\n", i, g[i], f[i]);
    // }
    return f[s.length()-1];
  }

  public static void main(String[] args) {
    String s = "(()()(())((";
    System.out.println(new S0032().longestValidParentheses(s));
  }  
}
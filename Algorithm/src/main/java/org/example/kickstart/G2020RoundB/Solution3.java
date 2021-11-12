package org.example.kickstart.G2020RoundB;

import java.util.*;
import java.io.*;


public class Solution3 {

  static class Pai{
    public long w = 0;
    public long h = 0;
  }
  static class StackElem{
    public long type; // 0 (; 1 co; 2 off;
    public long value;
    public StackElem(long type, long value) {
      this.type = type;
      this.value = value;
    }
  }

  public static void cStack(Stack<StackElem> wStack) {
    StackElem wElem;
    long mod = 1_000_000_000;
    wElem = wStack.pop();
    StackElem wOff = new StackElem(2, 0);
    while(wElem.type != 0) {
      wOff.value = (wOff.value +  wElem.value + mod) % mod ;
      wElem = wStack.pop();
    }
    wElem = wStack.pop();
    long repeat = wOff.value;
    while(wElem.value > 1) {
      wOff.value = (wOff.value + repeat + mod) % mod;
      wElem.value--;
    }
    wStack.add(wOff);
  }

  public static Pai solve_v1(String str) {
    Stack<StackElem> wStack = new Stack<>();
    Stack<StackElem> hStack = new Stack<>();

    String s = "1(" + str + ")";

    for(int i=0; i<s.length(); i++) {
      if(s.charAt(i) >='1' && s.charAt(i) <='9'){
        wStack.add(new StackElem(1, s.charAt(i) - '0'));
        hStack.add(new StackElem(1, s.charAt(i) - '0'));
      } else if (s.charAt(i) == '(') {
        wStack.add(new StackElem(0, 0));
        hStack.add(new StackElem(0, 0));
      } else if(s.charAt(i) == 'E') {
        wStack.add(new StackElem(2, +1));
      } else if(s.charAt(i) == 'W') {
        wStack.add(new StackElem(2, -1));
      } else if(s.charAt(i) == 'S') {
        hStack.add(new StackElem(2, +1));
      } else if (s.charAt(i) == 'N') {
        hStack.add(new StackElem(2, -1));
      } else if (s.charAt(i) == ')') {
        cStack(wStack);
        cStack(hStack);
      }
    }

    Pai ans = new Pai();
    ans.w = wStack.peek().value + 1;
    ans.h = hStack.peek().value + 1;
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    long t = in.nextInt(); // Scanner has functions to read longs, longs, strings, chars, etc.
    String s = in.nextLine();
    for (long i = 1; i <= t; ++i) { 
      s = in.nextLine();
      // System.out.prlongln("----" + s.charAt(s.length()-1) );
      Pai ans = solve_v1(s);
      System.out.println("Case #" + i + ": " + ans.w + " " + ans.h);
    }
  } 
}

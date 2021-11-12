package org.example.kickstart;

import java.util.*;
import java.io.*;



public class Solution {
  
  public static int solve() {

    return 0;
  }

  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE > 1_000_000_000);
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      System.out.println("Case #" + i + ": " + solve());
    }
  } 
}
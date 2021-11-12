package org.example.kickstart.G2020RoundG;

import java.util.*;
import java.io.*;



public class Solution1 {
  
  public static int solve(String s) {
    List<Integer> kick = new ArrayList<>();
    List<Integer> start = new ArrayList<>();
    int ans = 0;
    for(int i=0; i<s.length(); i++) {
      if(s.charAt(i) == 'K' && i+4<=s.length() && s.substring(i, i+4).equals("KICK")) {
        kick.add(i);
      }
      if(s.charAt(i) == 'S' && i+5 <= s.length() && s.substring(i, i+5).equals("START")){
        start.add(i);
      }
    }
    if(kick.size() == 0 || start.size() == 0) return ans;
    int j = 0;
    for(int i=0; i<kick.size(); i++) {
      while(j<start.size() && kick.get(i) > start.get(j)) j++;
      if(j<start.size()) {
        ans += start.size() - j;
      } else {
        break;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    String s;
    s = in.nextLine();
    for (int i = 1; i <= t; ++i) {
      s = in.nextLine();
      System.out.println("Case #" + i + ": " + solve(s));
    }
  } 
}

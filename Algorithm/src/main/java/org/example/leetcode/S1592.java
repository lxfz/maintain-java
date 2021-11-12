package org.example.leetcode;

import java.util.*;

public class S1592 {

  public String reorderSpaces(String text) {
    List<String> srtList = new ArrayList<>();
    String s = "";
    int cnt = 0;
    for(int i=0; i<text.length(); i++) {
      if(text.charAt(i) == ' '){
        cnt++;
        if(s!="") {
          srtList.add(s);
          s = "";
        }
      } 
      else {
        s = s+text.charAt(i);
      }
    }

    return text;
  }

  public static void main(String[] args) {
    String text = "123";
    System.out.println(new S1592().reorderSpaces(text));
  }
  
}

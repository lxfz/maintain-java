package org.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.lang.model.element.Element;

public class S0139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[][] f = new boolean[s.length()][s.length()];
    int j = 0 ;
    for(int len = 1; len <= s.length(); len++) {
      for(int i=0; i<s.length(); i++) {
        j = i+ len - 1;
        if(j >= s.length()) break;

        if(wordDict.contains(s.substring(i, j+1))) {
          f[i][j] = true;
        } else {
          for(int k=i; k<j; k++) {
            f[i][j] = f[i][j] || (f[i][k] && f[k+1][j]);
          }
        }
      }
    }
    return f[0][s.length()-1]; 
  }


  public boolean wordBreak_ref(String s, Set<String> dict) {    
    boolean[] f = new boolean[s.length() + 1];
    f[0] = true;
    //Second DP
    for(int i=1; i <= s.length(); i++){
        for(int j=0; j < i; j++){
            if(f[j] && dict.contains(s.substring(j, i))){
                f[i] = true;
                break;
            }
        }
    } 
    return f[s.length()];
  }
  public static void main(String[] args) {

    
  }
  
}

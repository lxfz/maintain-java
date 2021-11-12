package org.example.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class S0140 {

  public List<String> solve(String s, List<List<Integer>> f, int i) {
    if(i<0) return new ArrayList<>();
    List<String> res = new ArrayList<>();
    String tempStr = "";
    for(int j=0; j<f.get(i).size(); j++) {
      tempStr = s.substring(f.get(i).get(j), i+1);
      List<String> subRes = solve(s, f, f.get(i).get(j)-1);
      for(int k=0; k<subRes.size(); k++) {
        res.add(subRes.get(k) + " " + tempStr);
      }
      if(subRes.size() == 0) {
        res.add(tempStr);
      }
    }
    return res;
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<List<Integer>> f = new ArrayList<List<Integer>>();
    List<String> ans = null; 
    for(int i=0; i<s.length(); i++) {
      f.add(new ArrayList<>());
    }
    for(int i=0; i<s.length(); i++) {
      for(int j=0; j<=i; j++) {
        if(wordDict.contains(s.substring(j, i+1))) {
          if(j == 0 || f.get(j-1).size() > 0) {
            f.get(i).add(j);
          }
        }
      }
    }
    ans = solve(s, f, s.length()-1);
    return ans;
  }

  public static void main(String[] args) {
    String s = "a"; 
    String[] dict = {"a"};
    List<String> wordDict = new ArrayList<>();
    wordDict.addAll(Arrays.asList(dict));
    List<String> ans = new S0140().wordBreak(s, wordDict);
    for(int i=0; i<ans.size(); i++) {
      System.out.println(ans.get(i));
    }
  }
}

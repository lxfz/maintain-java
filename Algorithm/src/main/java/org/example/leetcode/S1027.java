package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S1027 {

  public int longestArithSeqLength(int[] A) {
    int ans = 0;
    // int[] g = new int[A.length];
    List<Map<Integer, Integer>> f = new ArrayList<Map<Integer, Integer>>();
    for(int i=0; i<A.length; i++) f.add(new HashMap<>());

    for(int i=0; i<A.length; i++) {
      for(int j=i-1; j>0; j++) {
       ans = Math.max(f.get(j).get(A[i]-A[j]) + 1, ans);
      }
      
    }


    return 0;
  }
  
}
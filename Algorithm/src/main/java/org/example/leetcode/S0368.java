package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0368 {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> x = new ArrayList<Integer>();
    x.add(nums[0]);
    results.add(x);
    int ans = 0;
    for(int i=1; i<nums.length; i++) {
      List<Integer> tempResult = new ArrayList<>();
      int largestPreSet = -1;
      for(int j=0; j<i; j++) {
        List<Integer> L = results.get(j);
        if(nums[i] % L.get(L.size()-1) == 0 && (largestPreSet == -1 || L.size() > results.get(largestPreSet).size())) {
          largestPreSet = j;
        }
      }
      if(largestPreSet != -1)
        tempResult.addAll(results.get(largestPreSet));
      tempResult.add(nums[i]);
      results.add(tempResult);
      if(tempResult.size() > results.get(ans).size()) {
        ans = i;
      }
    }
    return results.get(ans);
  }

  public static void main(String[] args) {
  }
  
}

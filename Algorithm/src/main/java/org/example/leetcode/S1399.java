package org.example.leetcode;

public class S1399 {

  public static int countLargestGroup(int n) {
    int[] size = new int[50];
    int largestSize = 0;
    int sum = 0;
    int tempK = 0;
    int ans = 0;
    
    for(int k = 1; k<=n; k++) {
      sum = 0;
      tempK = k;
      while(tempK>0) {
        sum += tempK % 10;
        tempK /= 10;
      }
      size[sum]++;
      if(size[sum] > largestSize) {
        largestSize = size[sum];
      }
    }
    for(int i : size) {
      if(i == largestSize) ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 1;
    System.out.println(countLargestGroup(n));
  }
  
}

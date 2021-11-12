package org.example.leetcode;

public class S1108 {
  static class Solution {
    public String defangIPaddr(String address) {
      StringBuilder res = new StringBuilder();
      for(int i=0; i<address.length(); i++){
        if(address.charAt(i) == '.'){
          res.append("[.]");
        } else {
          res.append(address.charAt(i));
        }
      }
      return res.toString();
    }
  }

  public static void main(String[] args) {
    
  }
  
}
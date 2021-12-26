package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class S0087 {

//  public boolean isScramble_01_fail(String s1, String s2) {
//
//    ArrayList<ArrayList<HashSet<String>>> f = new ArrayList<>();
//    int len = s2.length();
//    for(int i=0; i<len ;i++) {
//      f.add(new ArrayList<>());
//      for(int j=0; j<len; j++) {
//        f.get(i).add(new HashSet<>());
//      }
//    }
//
//    for(int i=0; i<len; i++) {
//      f.get(i).get(i).add(Character.toString(s2.charAt(i)));
//    }
//
//    int j = 0;
//    for(len=1; len<=s2.length(); len++) {
//      for(int i=0; i<s2.length() - len + 1; i++) {
//        j = i + len - 1;
//        for(int k=i; k<j; k++) {
//          for(String a : f.get(i).get(k)) {
//            for(String b : f.get(k+1).get(j)) {
//              f.get(i).get(j).add(a + b);
//              f.get(i).get(j).add(b + a);
//            }
//          }
//        }
//      }
//    }
//    for(String s : f.get(0).get(s2.length()-1)) {
//      if(s.equals(s1)) return true;
//      // System.out.println(s);
//    }
//    return false;
//  }


  public boolean isScramble_TLE(String s1, String s2) {
     if(s1.equals(s2)) return true;
     int[] count = new int[26];
     for(int i=0; i<s1.length(); i++){
       count[s1.charAt(i) - 'a']++;
       count[s2.charAt(i) - 'a']--;
     }   
     for(int i=0; i<26; i++) {
       if (count[i] != 0) return false;
     }

     for(int i=1; i<s1.length(); i++) {
       if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
          return true;
       if (isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0, s2.length()-i)))
          return true;
     }
    return false;
  }

  Map<String, Boolean> map = new HashMap<>();
  public boolean isScramble(String s1, String s2) {
      StringBuilder sb = new StringBuilder();
      sb.append(s1);
      sb.append(s2);
      String key = sb.toString();
      
      if (map.containsKey(key)) {
          return map.get(key);
      }
      
      if (s1.equals(s2)) {
          map.put(key, true);
          return true;
      }
      
      int[] letters = new int[26];
      for (int i = 0; i < s1.length(); i++) {
          letters[s1.charAt(i) - 'a']++;
          letters[s2.charAt(i) - 'a']--;
      }
      for (int i = 0; i < 26; i++) {
          if (letters[i] != 0) {
              map.put(key, false);
              return false;
          }
      }
      
      for (int i = 1; i < s1.length(); i++) {
          if ( isScramble(s1.substring(0,i), s2.substring(0,i)) 
             && isScramble(s1.substring(i), s2.substring(i)) ) {
              map.put(key, true);
              return true;
          }
              
          if ( isScramble(s1.substring(0,i), s2.substring(s1.length() - i)) 
             && isScramble(s1.substring(i), s2.substring(0,s1.length() - i)) ) {
              map.put(key, true);
              return true;
          }
      }
      
      map.put(key, false);
      return false;
  }

  public static void main(String[] args) {
    String s1 = "great", s2 = "rgeat";
    System.out.println(new S0087().isScramble(s1, s2));
    // char[] c1 = s1.toCharArray();
    // char[] c2 = s2.toCharArray();
    // System.out.println(Arrays.equals(c1, c2));
  }

}

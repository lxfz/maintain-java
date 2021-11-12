package org.example.leetcode;

public class S1585 {

  public boolean isTransformable(String s, String t) {
     boolean res = true;
     boolean[] visited = new boolean[s.length()];
     int i=s.length()-1, j= s.length()-1;
     int k = 0;
     int[] prev = new int[10];

     while(i>=0 && j>=0) {
      if(s.charAt(i) == t.charAt(j)) {
        visited[i] = true;
        while(i>=0 && visited[i]) i--;
        j--;
      } else {
        // to avoid TLE
        if(prev[t.charAt(j)-'0'] > 0) k = Math.min(prev[t.charAt(j)-'0'], i);
        else k=i;
        while(k>=0){
          if(!visited[k] && s.charAt(k) > t.charAt(j)) return false;
          if(!visited[k] && s.charAt(k) == t.charAt(j)) break;
          k--;
        }
        if(k<0)return false;
        visited[k] = true;
        prev[t.charAt(j)-'0'] = k-1;
        j--;
      }
     }
     return res;
  }

  public static void main(String[] args) {
    String s = "432513576",
    t = "231435567";
    System.out.println(new S1585().isTransformable(s, t));
  }
  
}

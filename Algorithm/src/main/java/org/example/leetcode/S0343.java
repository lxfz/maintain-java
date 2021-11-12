package org.example.leetcode;

public class S0343 {

  public int integerBreak(int n) {
    int ans[] = new int[n+1];
    ans[1] = 1;
    ans[2] = 1;
    for(int i=3; i<=n; i++) {
      ans[i] = 1;
      int t = i;
      int k = (int)Math.sqrt(i);
      while(t - k >= k) {
        ans[i] *= k;
        t -= k;
      }
      ans[i] = Math.max(ans[i] * t, ans[i]* (t-k) * k);


      // for(int j=1; j<=i/2; j++) {
      //   ans[i] = Math.max(ans[i], ans[i-j]*ans[j]);
      //   ans[i] = Math.max(ans[i], (i-j)*j);
      //   ans[i] = Math.max(ans[i], ans[i-j] * j);
      //   ans[i] = Math.max(ans[i], ans[j] * (i-j));
      // }
    }
    return ans[n];
  }
public static void main(String[] args) {
  S0343 s = new S0343();
  System.out.println(s.integerBreak(8));
}
  


  
}

package org.example.leetcode;

public class S0374 {

  public int guessNumber(int n) {
    int left = 1;
    int right = n;
    int mid = 0;
    int r = 0;
    while(left <= right) {
      mid = left + (right - left) / 2;
      // r = guess(mid);
      if (r == 0) {
        return mid;
      } else if (r == -1) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}

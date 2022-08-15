package org.example.binarysearch;

public class FirstBadVersion {

  public boolean isBadVersion(int x) {
    return true;
  }

  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (!isBadVersion(mid)) left = mid + 1;
      else right = mid - 1;
    }
    return left;
  }
}

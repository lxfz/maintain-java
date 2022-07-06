package org.example.TwoPointers;

/**
 * 11. 盛最多水的容器
 */
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    if (height.length <= 1) {
      return 0;
    }

    int left = 0;
    int right = height.length - 1;
    int ans = 0;
    int currentArea = 0;
    while (left < right) {
      currentArea = Math.min(height[left], height[right]) * (right - left);
      ans = Math.max(ans, currentArea);
      if (height[left] <= height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return ans;
  }
}

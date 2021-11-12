package org.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution0004 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> nums = new ArrayList<Integer>();
    for (int num : nums1) {
      nums.add(num);
    }
    for (int num : nums2) {
      nums.add(num);
    }
    Collections.sort(nums);
    int allLen = nums1.length + nums2.length;
    if (allLen % 2 != 0) {
      return nums.get(allLen / 2);
    } else {
      return (nums.get(allLen / 2 - 1) + nums.get(allLen / 2)) / 2.0;
    }
  }

  public static void main(String[] args) {
    Solution0004 solution0004 = new Solution0004();
    int[] nums1 = {1, 3};
    int[] nums2 = {2, 4};
    System.out.println(solution0004.findMedianSortedArrays(nums1, nums2));
  }

}

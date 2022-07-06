package org.example.leetcode.tencent;

public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int pos = 1;
    int pointer = 1;
    while (pointer < nums.length) {
      if (nums[pointer] == nums[pos]) {
        pointer++;
      } else {
        nums[pos++] = nums[pointer++];
      }
    }
    return pos;
  }
}

package org.example.Heap;

/**
 * 没有while
 */
public class Heapify {

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public void siftDown(int[] nums, int cur) {
    int min = cur;
    if ((2 * cur + 1) < nums.length && nums[2 * cur + 1] < nums[min]) min = 2 * cur + 1;
    if ((2 * cur + 2) < nums.length && nums[2 * cur + 2] < nums[min]) min = 2 * cur + 2;
    if (min != cur) { // 重要
      swap(nums, cur, min);
      siftDown(nums, min);
    }
  }

  public void siftUp(int[] nums, int cur) {
    /**
     * for insert
     */
    if (cur != 0) { // 重要
      int parent = (cur - 1) / 2;
      if (nums[cur] < nums[parent]) {
        swap(nums, cur, parent);
        siftUp(nums, parent);
      }
    }
  }

  public void heapify(int[] nums) {
    /**
     * 把这个数组变成一个最小堆
     */
    for (int i = nums.length / 2 - 1; i >= 0; i--) {
      siftDown(nums, i);
    }
  }
}

package org.example.cyclicsort;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // 找到目前第i位上的数，它应该放在nums[i]的地方
            // 如果不对，就交换
            int j = nums[i];
            if (j < nums.length && nums[j] != j) {
                swap(nums, i, j); // 第j位上的数位置对了
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

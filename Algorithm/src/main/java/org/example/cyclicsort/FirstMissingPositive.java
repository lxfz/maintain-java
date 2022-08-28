package org.example.cyclicsort;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        // 问题转化为 find first missing natural number
        for(; i<nums.length; i++) nums[i] -= 1;
        i = 0;
        while(i < nums.length) {
            int j = nums[i];
            if(j >= 0 && j < nums.length && nums[j] != j) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        for(i=0; i<nums.length; i++) {
            if( i != nums[i]) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

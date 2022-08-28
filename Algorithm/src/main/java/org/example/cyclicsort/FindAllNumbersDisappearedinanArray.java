package org.example.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            nums[i] -= 1;
        int i = 0;
        while (i < nums.length) {
            int j = nums[i]; // nums[i]/j 应该放在 j 位
            if (j != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                res.add(i + 1); // 重复是add值，missing是add下表
            }
        }
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

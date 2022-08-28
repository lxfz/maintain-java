package org.example.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= 1;
        }

        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (j != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }

        }
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                res.add(nums[i] + 1);
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

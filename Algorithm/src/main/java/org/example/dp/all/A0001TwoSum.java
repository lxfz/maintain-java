package org.example.dp.all;

import java.util.HashMap;
import java.util.Map;

public class A0001TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(target-nums[i], i);
        }
        for(int i=0; i<nums.length; i++) {
            int index = map.getOrDefault(nums[i], -1);
            if(index != -1 && index != i) {
                return new int[]{i, index};
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        A0001TwoSum solution = new A0001TwoSum();
        for(int x : solution.twoSum(nums, target)) {
            System.out.println(x);
        }
    }
    
}

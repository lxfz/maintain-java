package org.example.dp.all;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A00153Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(-nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int index = map.getOrDefault(nums[i] + nums[j], -1);
                if(index != -1 && index!= i && index != j) {
                    
                }
            }
        }


        return null;
    }

    public static void main(String[] args) {
        
    }
}

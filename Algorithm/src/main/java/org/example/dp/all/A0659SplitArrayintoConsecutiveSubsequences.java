package org.example.dp.all;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class A0659SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        PriorityQueue<List<Integer>> consecutiveSubsequeces = new PriorityQueue<>((a, b) -> {
            if (a.get(a.size() - 1) == b.get(b.size() - 1)) {
                return a.size() - b.size();
            } else {
                return a.get(a.size() - 1) - b.get(b.size() - 1);
            }
        });
        List<Integer> top = null;
        for (int i = 0; i < nums.length; i++) {
            if (!consecutiveSubsequeces.isEmpty()) {
                while (!consecutiveSubsequeces.isEmpty()) {
                    top = consecutiveSubsequeces.peek();
                    int topValue = top.get(top.size() - 1);
                    
                    if(topValue < nums[i] - 1) {
                        top = consecutiveSubsequeces.poll();
                        if(top.size() < 3) {
                            return false;
                        }
                    } else if(topValue == nums[i] - 1) {
                        top = consecutiveSubsequeces.poll();
                        top.add(nums[i]);
                        consecutiveSubsequeces.add(top);
                        break;
                    } else if(topValue == nums[i]) {
                        consecutiveSubsequeces.add(new ArrayList<>(List.of(nums[i])));
                        break;
                    }
                }
            } 

            if(consecutiveSubsequeces.isEmpty()) {
                consecutiveSubsequeces.add(new ArrayList<>(List.of(nums[i])));
            }
            System.out.println(consecutiveSubsequeces.peek().size());
        }

        while (!consecutiveSubsequeces.isEmpty()) {
            top = consecutiveSubsequeces.poll();
            if (top.size() < 3)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5,5};
        A0659SplitArrayintoConsecutiveSubsequences solution = new A0659SplitArrayintoConsecutiveSubsequences();
        System.out.println(solution.isPossible(nums));
    }
}

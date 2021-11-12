package org.example.leetcode;

import java.util.List;

public class S0120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.get(triangle.size() - 1).size();
        if (len == 0) return 0;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) f[i] = triangle.get(triangle.size() - 1).get(i);
        for (int n = triangle.size() - 2; n >= 0; n--) {
            for (int i = 0; i < triangle.get(n).size(); i++) {
                f[i] = triangle.get(n).get(i) + Math.min(f[i], f[i + 1]);
            }
        }
        return f[0];
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}

package org.example.dp.tree;

import java.util.Arrays;

class TreeAncestor {

    int[][] dp = null;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][n];
        Arrays.fill(dp[0], -1);
        dp[0][0] = 0;

        


    }
    
    public int getKthAncestor(int node, int k) {
        return 0;
    }
}

public class KthAncestorofaTreeNode {
    
}

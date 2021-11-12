package org.example.kickstart;

import java.util.*;
import java.io.*;



public class  S2020RoundA04{

  public static int ans = 0;

  static class TreeNode{
    public int times;
    public int length;
    public ArrayList<TreeNode> children = new ArrayList<>();
    public TreeNode(int t, int l) {
      this.times = t;
      this.length = l;
    }
  }

  public static void buildTree(TreeNode root, String s, int p) {
    if(s.length() == p) return;
    if(root.children.size() == 0) {
      for(int i=0; i<26; i++) {
        root.children.add(new TreeNode(0, root.length+1));
      }
    }
    TreeNode node = root.children.get(s.charAt(p) - 'A');
    node.times++;
    buildTree(node, s, p+1);
  }

  public static int solveTree(TreeNode node, int k) {
    int totalMinus = 0;
    for(int i=0; i<node.children.size(); i++) {
      totalMinus += solveTree(node.children.get(i), k);
    }
    if(node.times - totalMinus >= k) {
      totalMinus += k;
      node.times -= totalMinus;
      ans += node.length;
    }
    return totalMinus;
  }

  
  public static int solve(String[] ss, int n, int k) {
    ans = 0;
    TreeNode root = new TreeNode(0, 0);
    for(int i=0; i<n; i++) {
      buildTree(root, ss[i], 0);
    }
    solveTree(root, k);
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    String[] ss = new String[1_000_01];
    int n, k;
    for (int i = 1; i <= t; ++i) {
      n = in.nextInt();
      k = in.nextInt();
      in.nextLine();
      for(int j=0; j<n ;j++) {
        ss[j] = in.nextLine();
      }
      System.out.println("Case #" + i + ": " + solve(ss, n, k));
    }
  } 
}
package org.example.segtree;

public class SegTree {


  /**
   * 线段树不考虑添加元素，即区间固定，使用4n的静态空间即可。
   */

  public static final int MAX_LEN = 1000;


  public static void build_tree(int[] arr, int[] tree, int node, int start, int end) {
    // node 就代表 start 到 end
    if (start == end) {
      tree[node] = arr[start];
    } else {
      int mid = (start + end) / 2;
      int left_node = 2 * node + 1;
      int right_node = 2 * node + 2;
      build_tree(arr, tree, left_node, start, mid);
      build_tree(arr, tree, right_node, mid + 1, end);
      tree[node] = tree[left_node] + tree[right_node];
    }
  }

  public static void update_tree(int[] arr, int[] tree, int node, int start, int end, int idx, int val) {
    // arr[idx] = val

    if (start == end) {
      arr[idx] = val;
      tree[node] = val;
    } else {
      int mid = (start + end) / 2;
      int left_node = 2 * node + 1;
      int right_node = 2 * node + 2;
      if (idx >= start && idx <= mid) {
        update_tree(arr, tree, left_node, start, mid, idx, val);
      } else { // mid < idx <= end
        update_tree(arr, tree, right_node, mid + 1, end, idx, val);
      }
      tree[node] = tree[left_node] + tree[right_node];
    }
  }


  public static int query_tree(int[] arr, int[] tree, int node, int start, int end, int L, int R) {
    System.out.printf("start = %d\n", start);
    System.out.printf("end   = %d\n\n", end);
    if (R < start || L > end) {
      // 如果不在计算范围内，返回0
      return 0;
    } else if (L <= start && end <= R) {
      return tree[node];
    } else if (start == end) {
      // 叶子节点
      return tree[node];
    } else {
      int mid = (start + end) / 2;
      int left_node = 2 * node + 1;
      int right_node = 2 * node + 2;
      int sum_left = query_tree(arr, tree, left_node, start, mid, L, R);
      int sum_right = query_tree(arr, tree, right_node, mid + 1, end, L, R);

      return sum_left + sum_right;
    }
  }


  public static void main(String[] args) {

    int[] arr = {1, 3, 5, 7, 9, 11};
    int size = 6;
    int[] tree = new int[MAX_LEN];
    build_tree(arr, tree, 0, 0, size - 1);

    for (int i = 0; i < 15; i++) {
      System.out.println(tree[i]);
    }

    System.out.println();
    update_tree(arr, tree, 0, 0, size - 1, 4, 6);
    for (int i = 0; i < 15; i++) {
      System.out.println(tree[i]);
    }

    System.out.println();
    int s = query_tree(arr, tree, 0, 0, size - 1, 2, 5);
    System.out.println(s);

  }
}

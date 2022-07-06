package org.example.leetcode.tencent;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class MergeTwoLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode first = list1;
    ListNode second = list2;
    ListNode ans = new ListNode();
    ListNode tail = ans;
    while (first != null || second != null) {
      if (first == null) {
        tail.next = second;
        second = second.next;
      } else if (second == null) {
        tail.next = first;
        first = first.next;
      } else {
        if (first.val < second.val) {
          tail.next = first;
          first = first.next;
        } else {
          tail.next = second;
          second = second.next;
        }
      }
      tail = tail.next;
    }

    return ans.next;
  }
}

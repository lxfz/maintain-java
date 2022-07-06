package org.example.leetcode.maths;

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

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode first = l1;
    ListNode second = l2;
    int carry = 0;
    int a = 0;
    int b = 0;
    ListNode head = null;
    ListNode tail = null;
    ListNode tempNode = null;

    while (first != null || second != null) {
      tempNode = new ListNode();
      a = first == null ? 0 : first.val;
      b = second == null ? 0 : second.val;
      tempNode.val = (a + b + carry) % 10;
      carry = (a + b + carry) / 10;
      if (tail == null) {
        tail = tempNode;
        head = tempNode;
      } else {
        tail.next = tempNode;
        tail = tail.next;
      }
      if (first != null) first = first.next;
      if (second != null) second = second.next;
    }
    if(carry != 0) {
      tempNode = new ListNode(carry);
      tail.next = tempNode;
    }

    return  head;
  }
}

package org.example.dp.all;

import java.util.PriorityQueue;

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

class PriorityQueueMember{
    int listIndex = -1;
    int value = -1;

    public PriorityQueueMember(int listIndex, int value) {
        this.listIndex = listIndex;
        this.value = value;
    }
}

public class A0023MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<PriorityQueueMember> pq = new PriorityQueue<>((a, b) -> {
            return a.value - b.value;
        });

        ListNode fakeHead = new ListNode();
        ListNode tail = fakeHead;
        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                pq.add(new PriorityQueueMember(i, lists[i].val));
            }
        }

        PriorityQueueMember tempMember;

        while(!pq.isEmpty()) {
            ListNode tempNode = new ListNode();
            tail.next = tempNode;

            tempMember = pq.poll();
            tempNode.val = lists[tempMember.listIndex].val;

            if(lists[tempMember.listIndex].next != null) {
                lists[tempMember.listIndex] = lists[tempMember.listIndex].next;
                pq.add(new PriorityQueueMember(tempMember.listIndex, lists[tempMember.listIndex].val));
            }

            tail = tempNode;
        }
        return fakeHead.next;
    }
}

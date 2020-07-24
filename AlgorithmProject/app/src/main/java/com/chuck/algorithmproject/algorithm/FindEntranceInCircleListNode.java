package com.chuck.algorithmproject.algorithm;

public class FindEntranceInCircleListNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getMeetNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return fastNode;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = getMeetNode(head);
        if (meetNode == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = meetNode;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}

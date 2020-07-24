package com.chuck.algorithmproject.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

public class RevertNode1 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode nextNode = null;

        while (head != null) {
            nextNode = head.next;//将当前节点的下一个节点保存
            head.next = preNode;//将上一个节点设置为当前节点的下一个节点
            preNode = head;//将当前节点设置为上一个节点
            head = nextNode;//将第一步中的下一个节点设置为当前节点，继续循环
        }
        return preNode;
    }
}

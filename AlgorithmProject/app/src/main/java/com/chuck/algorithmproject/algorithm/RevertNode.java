package com.chuck.algorithmproject.algorithm;

import java.util.Stack;

public class RevertNode {
    public static class Node {
        public int value;
        public Node next;
        public boolean head;
    }

    public static Node rootNode = new Node();

    public static void addValue(int value) {
        rootNode.head = true;
        Node tempNode = rootNode;
        while (tempNode != null) {
            if (tempNode.next == null) {
                Node curNode = new Node();
                curNode.value = value;
                tempNode.next = curNode;
                break;
            }
            tempNode = tempNode.next;
        }
    }

    public static void buildNode(int[] array) {
        for (int index = 0; index < array.length; index++) {
            addValue(array[index]);
        }
    }

    public static void revertNode(Node node) {
        Node tempNode = node;
        Stack<Node> nodeStack = new Stack<>();
        while (tempNode != null) {
            nodeStack.push(tempNode);
            tempNode = tempNode.next;
        }
        while (!nodeStack.isEmpty()) {
            Node popedNode = nodeStack.pop();
            if(popedNode.head){
                continue;
            }
            System.out.println("poped value is:" + popedNode.value);
        }
    }

    public static void test() {
        int[] array = {3, 4, 5, 6, 1, 2, 8, 9};
        buildNode(array);
        revertNode(rootNode);
//        System.out.println("node is:" + node.value);
    }

}
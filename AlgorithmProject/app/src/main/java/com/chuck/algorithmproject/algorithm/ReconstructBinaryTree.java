package com.chuck.algorithmproject.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReconstructBinaryTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
    }

    public static TreeNode reconstructTreeNode(int[] pre, int[] middle) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        int rootIndex = 0;
        int rootValue = pre[0];
        TreeNode rootNode = new TreeNode();
        rootNode.value = rootValue;
        if (pre.length == 1) {
            return rootNode;
        }
        int leftPreStart = 1;
        int leftPreEnd = rootIndex + 1;

        int leftMiddleStart = 0;
        int leftMiddleEnd = rootIndex + 1;

        int rightPreStart = rootIndex + 1;
        int rightPreEnd = pre.length;

        int rightMiddleStart = rootIndex + 1;
        int rightMiddleEnd = middle.length;

        int[] leftPreNode = Arrays.copyOfRange(pre, leftPreStart, leftPreEnd);
        int[] leftMiddleNode = Arrays.copyOfRange(middle, leftMiddleStart, leftMiddleEnd);
        int[] rightPreNode = Arrays.copyOfRange(pre, rightPreStart, rightPreEnd);
        int[] rightMiddleNode = Arrays.copyOfRange(middle, rightMiddleStart, rightMiddleEnd);
        rootNode.left = reconstructTreeNode(leftPreNode, leftMiddleNode);
        rootNode.right = reconstructTreeNode(rightPreNode, rightMiddleNode);
        return rootNode;
    }

    public static void scanTreeNode(TreeNode rootNode) {
        if (rootNode != null) {
            System.out.println("binary tree front scan is:" + rootNode.value);
            scanTreeNode(rootNode.left);
            System.out.println("binary tree middle scan is:" + rootNode.value);
            scanTreeNode(rootNode.right);
            System.out.println("binary tree back scan is:" + rootNode.value);
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] middle = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode rootNode = reconstructTreeNode(pre, middle);
        scanTreeNode(rootNode);
    }
}

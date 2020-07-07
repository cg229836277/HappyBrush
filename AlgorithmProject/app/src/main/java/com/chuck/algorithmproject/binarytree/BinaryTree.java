package com.chuck.algorithmproject.binarytree;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private final static String TAG = "BinaryTree";
    private static int[] number = {15, 28, 33, 16, 49, 10, 34, 61, 27, 36, 57, 68, 71, 16, 87, 90, 134, 243, 8, 51, 57};
    private static int size = number.length;
    private static BinaryTreeBase binaryTreeBase = null;

    public static void start() {
        binaryTreeBase = buildBinaryTree(binaryTreeBase, 0);
        Log.d(TAG, "buildBinaryTree finished");
        frontScan(binaryTreeBase);
        middleScan(binaryTreeBase);
        backScan(binaryTreeBase);
        layerScan();
    }

    /*
     *@Params :root,left for 2*k + 1,right for 2 * k + 2
     *@Author :chuck-os
     *@Date :2020/7/7
     */
    private static BinaryTreeBase buildBinaryTree(BinaryTreeBase binaryTreeBase, int index) {
        if (index >= size / 2) {
            return null;
        }
        if (binaryTreeBase == null) {
            binaryTreeBase = new BinaryTreeBase(number[index]);
        }
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        if (leftIndex < size) {
            binaryTreeBase.lChild = new BinaryTreeBase(number[leftIndex]);
            buildBinaryTree(binaryTreeBase.lChild, leftIndex);
        }
        if (rightIndex < size) {
            binaryTreeBase.rChild = new BinaryTreeBase(number[rightIndex]);
            buildBinaryTree(binaryTreeBase.rChild, rightIndex);
        }
        return binaryTreeBase;
    }

    /*
     *@Params :root,left,right
     *@Author :chuck-os
     *@Date :2020/7/7
     */
    public static void frontScan(BinaryTreeBase binaryTreeBase1) {
        if (binaryTreeBase == null) {
            binaryTreeBase = buildBinaryTree(binaryTreeBase, 0);
        }
        if (binaryTreeBase1 == null) {
            return;
        }
        Log.d(TAG, "frontScan number is:" + binaryTreeBase1.value);
        frontScan(binaryTreeBase1.lChild);
        frontScan(binaryTreeBase1.rChild);
    }

    /*
     *@Params :left,root,right
     *@Author :chuck-os
     *@Date :2020/7/7
     */
    public static void middleScan(BinaryTreeBase binaryTreeBase1) {
        if (binaryTreeBase == null) {
            binaryTreeBase = buildBinaryTree(binaryTreeBase, 0);
        }
        if (binaryTreeBase1 == null) {
            return;
        }
        middleScan(binaryTreeBase1.lChild);
        Log.d(TAG, "middleScan number is:" + binaryTreeBase1.value);
        middleScan(binaryTreeBase1.rChild);
    }

    /*
     *@Params :left,right,root
     *@Author :chuck-os
     *@Date :2020/7/7
     */
    public static void backScan(BinaryTreeBase binaryTreeBase1) {
        if (binaryTreeBase == null) {
            binaryTreeBase = buildBinaryTree(binaryTreeBase, 0);
        }
        if (binaryTreeBase1 == null) {
            return;
        }
        backScan(binaryTreeBase1.lChild);
        backScan(binaryTreeBase1.rChild);
        Log.d(TAG, "backScan number is:" + binaryTreeBase1.value);
    }

    /*
     *@Params :from one layer to another layer
     *@Author :chuck-os
     *@Date :2020/7/7
     */
    public static void layerScan() {
        if (binaryTreeBase == null) {
            binaryTreeBase = buildBinaryTree(binaryTreeBase, 0);
        }
        Queue<BinaryTreeBase> queue = new LinkedList();
        BinaryTreeBase tempBinaryTree = binaryTreeBase;
        queue.add(tempBinaryTree);
        while (tempBinaryTree != null) {
            tempBinaryTree = queue.poll();
            if (tempBinaryTree == null) {
                break;
            }
            Log.d(TAG, "layerScan number is:" + tempBinaryTree.value);
            if (tempBinaryTree.lChild != null) {
                queue.add(tempBinaryTree.lChild);
            }
            if (tempBinaryTree.rChild != null) {
                queue.add(tempBinaryTree.rChild);
            }
        }
    }
}

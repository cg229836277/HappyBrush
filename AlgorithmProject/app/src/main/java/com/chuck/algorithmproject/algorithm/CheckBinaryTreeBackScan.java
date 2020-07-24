package com.chuck.algorithmproject.algorithm;

public class CheckBinaryTreeBackScan {

    public boolean isBST(int[] array, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        int root = array[end];
        int splitIndex = 0;
        for (int index = 0; index < end - 1; index++) {
            if (array[index] < root && array[index + 1] > root) {
                splitIndex = index;
                break;
            }
        }
        if (splitIndex == 0) {
            return true;
        }
        int leftIndex = start;
        for (; leftIndex <= splitIndex; leftIndex++) {
            if (array[leftIndex] > root) {
                return false;
            }
        }
        int rightIndex = splitIndex + 1;
        for (; rightIndex < end; rightIndex++) {
            if (array[rightIndex] < root) {
                return false;
            }
        }
        boolean left = isBST(array, start, splitIndex);
        boolean right = isBST(array, splitIndex + 1, end - 1);
        return left && right;
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }
}

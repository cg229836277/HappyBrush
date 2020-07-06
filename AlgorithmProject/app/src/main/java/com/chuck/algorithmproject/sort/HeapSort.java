package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

public class HeapSort {
    private static String TAG = "HeapSort";
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 6};
    private static int size = number.length;
    public static void heapSort() {
        buildMaxHeap();
        for (int index = size - 1; index > 0; index--) {
            swap(0, index);
            size--;
            adjustMaxHeap(0);
        }
    }

    private static void buildMaxHeap() {
        int start = size / 2 - 1;
        for (int index = start; index >= 0; index--) {
            adjustMaxHeap(index);
        }
        Log.d(TAG, "sorted result number is " + Arrays.toString(number));
    }

    private static void adjustMaxHeap(int point) {
        Log.d(TAG, "sorted point is " + point);
        int left = 2 * point + 1;
        int right = 2 * point + 2;
        int largest = point;
        if (left < size && number[left] > number[largest]) {
            largest = left;
        }
        if (right < size && number[right] > number[largest]) {
            largest = right;
        }
        if (largest != point) {
//            Log.d(TAG, "sorted point left is " + number[left] + " , right is " + number[right] + " , middle is " + number[point]);
            swap(point, largest);
            adjustMaxHeap(largest);
        }
        Log.d(TAG, "sorted number is " + Arrays.toString(number));
    }

    private static void swap(int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }
}

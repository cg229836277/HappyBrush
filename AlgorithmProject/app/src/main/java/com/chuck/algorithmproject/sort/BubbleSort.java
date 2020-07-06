package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

/*
 *@Params :冒泡排序
 *@Author :chuck-os
 *@Date :2020/7/2
 */
public class BubbleSort {
    //    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8};
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 6};
    private static String TAG = "BubbleSort";

    public static void bubbleSort() {
        int size = number.length;
        int compareCount = 1;
        Log.d(TAG, "sorted compare index 0 is " + Arrays.toString(number));
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (number[j + 1] < number[j]) {
                    int temp = number[j + 1];
                    number[j + 1] = number[j];
                    number[j] = temp;
                    Log.d(TAG, "sorted compare index " + (compareCount++) + " is " + Arrays.toString(number));
                }
            }
        }
        for (int temp : number) {
            Log.d(TAG, "sorted number is:" + temp);
        }
    }
}

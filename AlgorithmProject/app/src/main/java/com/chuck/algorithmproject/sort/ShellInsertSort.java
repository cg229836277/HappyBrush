package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

public class ShellInsertSort {
    private static String TAG = "ShellInsertSort";
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 6};
//    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8};
//    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8, 5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8, 6, 6, 6, 6, 6, 6, 6, 6};

    public static void shellInsertSort() {
        int size = number.length;
        int delta = size;
//        int initDelta = size / 2 + 1;
        while (true) {
            delta = delta / 2;
            for (int i = 0; i < delta; i++) {
                Log.d(TAG, "delta is " + delta + " , i = " + i);
                for (int j = i + delta; j < size; j += delta) {
                    int tempData = number[j];
                    int k = j - delta;
                    while (k >= 0 && number[k] > tempData) {
                        number[k + delta] = number[k];
                        k -= delta;
                    }
                    number[k + delta] = tempData;
                }
            }
            if (delta == 1) {
                break;
            }
        }
        Log.d(TAG, "sorted number is " + Arrays.toString(number));
    }
}

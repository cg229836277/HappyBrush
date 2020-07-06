package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

public class ShellInsertSort {
    private static String TAG = "ShellInsertSort";
    //        private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 6};
//    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8};
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8, 5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8, 6, 6, 6, 6, 6, 6, 6, 6};

    public static void shellInsertSort() {
        int size = number.length;
        int initDelta = size / 2 + 1;
        for (int i = 0; i < initDelta; i++) {
            int delta = size / ((i + 1) * 2);
            delta = delta == 0 ? 1 : delta;
            Log.d(TAG, "delta is " + delta + " , i = " + i);
            for (int j = 0; j < size; j++) {
                int compareIndex = j + delta;
                if (compareIndex < size && number[compareIndex] < number[j]) {
                    Log.d(TAG, "hold number is " + number[j] + ",compare number is " + number[compareIndex]);
                    int temp = number[j];
                    number[j] = number[compareIndex];
                    number[compareIndex] = temp;
                }
            }

            Log.d(TAG, "sorted number is " + Arrays.toString(number));
        }
    }
}

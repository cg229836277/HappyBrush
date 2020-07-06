package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

public class SelectionSort {
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8};
//    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 6};
    private static String TAG = "SelectionSort";

    public static void selectionSort() {
        int size = number.length;
        int minimumIndex = 0;
        for (int i = 0; i < size; i++) {
            int minimumNumber = number[i];
            boolean findMinimum = false;
            for (int j = i + 1; j < size; j++) {
                if (number[j] < minimumNumber) {
                    minimumNumber = number[j];
                    minimumIndex = j;
                    findMinimum = true;
                }
            }
            Log.d(TAG, "minimum number is " + number[minimumIndex]);
            if (!findMinimum) {
                continue;
            }
            int tempNumber = number[minimumIndex];
            number[minimumIndex] = number[i];
            number[i] = tempNumber;
            Log.d(TAG, "sorted number is " + Arrays.toString(number));
        }

        for (int temp : number) {
            Log.d(TAG, "sorted number is:" + temp);
        }
    }
}

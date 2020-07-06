package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

public class QuickSort {
    private static String TAG = "QuickSort";
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 6};

    public static void quickSort() {
        int size = number.length;
        searchMiddleNumber(0, size - 1);
    }

    private static void searchMiddleNumber(int start, int end) {
        int i = start;
        int j = end;
        int standardNumber = number[start];
        Log.d(TAG, "sorted standardNumber is " + standardNumber);
        while (i < j) {
            while (number[i] < standardNumber && i < j) {
                ++i;
            }
            while (number[j] > standardNumber && i < j) {
                --j;
            }
            Log.d(TAG, "searchMiddleNumber number is " + number[i] + " , " + number[j]);
            if (number[i] == number[j] && i < j) {
                i++;
            } else {
                int tempNumber = number[i];
                number[i] = number[j];
                number[j] = tempNumber;
                Log.d(TAG, "sorted number is " + Arrays.toString(number));
            }
        }
        if (i - 1 > start) {
            searchMiddleNumber(start, i - 1);
        }
        if (j + 1 < end) {
            searchMiddleNumber(j + 1, end);
        }
    }
}

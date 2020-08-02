package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

public class CountSort {
    private static String TAG = "CountSort";
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 3, 7, 6};

    public static void countSort() {
        int maxNumber = number[0];
        int minNumber = maxNumber;
        int size = number.length;
        for (int index = 0; index < size; index++) {
            if (number[index] > maxNumber) {
                maxNumber = number[index];
            }
            if (number[index] < minNumber) {
                minNumber = number[index];
            }
        }
        Log.e(TAG, "maxNumber:" + maxNumber + ",minNumber:" + minNumber);
        int tempArraySize = maxNumber - minNumber + 1;
        int[] tempArray = new int[tempArraySize];
        for (int index = 0; index < size; index++) {
            ++tempArray[number[index] - minNumber];
        }
        int originNumberIndex = 0;
        for (int index = 0; index < tempArraySize; index++) {
            while (tempArray[index] != 0) {
                number[originNumberIndex++] = index + minNumber;
                --tempArray[index];
            }
        }
        Log.e(TAG, "sorted number is " + Arrays.toString(number));
    }
}

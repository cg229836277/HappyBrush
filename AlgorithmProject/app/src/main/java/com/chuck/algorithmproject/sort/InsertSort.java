package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

public class InsertSort {
    private static String TAG = "InsertSort";
    //    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 6};
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 12, 65, 4, 23, 2, 16, 15, 76, 56, 8};

    public static void insertSort() {
        int size = number.length;
        for (int i = 1; i < size; i++) {//stand out number
            int standOutNumber = number[i];
            Log.d(TAG, "stand out number is " + standOutNumber);
            for (int j = i - 1; j >= 0; j--) {//to be compared numbers
                if (standOutNumber < number[j]) {
                    number[i--] = number[j];
                    number[j] = standOutNumber;
                }
            }
            Log.d(TAG, "sorted number is " + Arrays.toString(number));
        }
        for (int temp : number) {
            Log.d(TAG, "sorted number is:" + temp);
        }
    }

}

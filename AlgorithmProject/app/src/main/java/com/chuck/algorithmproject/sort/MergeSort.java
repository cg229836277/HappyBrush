package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.Arrays;

public class MergeSort {
    private static String TAG = "MergeSort";
    private static int[] number = {5, 8, 3, 6, 9, 10, 34, 1, 7, 6};

    public static void mergeSort() {
        int size = number.length;
        int[] candidateArray = new int[size];
        sort(0, size - 1, candidateArray);
    }

    private static void sort(int left, int right, int[] candidateArray) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(left, mid, candidateArray);
            sort(mid + 1, right, candidateArray);
            merge(left, mid, right, candidateArray);
        }
    }

    private static void merge(int left, int mid, int right, int[] candidateArray) {
        int i = left;
        int j = mid + 1;
        int temp = 0;
        while (i <= mid && j <= right) {
            Log.d(TAG, "merge i is " + i + " , mid is " + mid + " , j is " + j + " , right is " + right);
            Log.d(TAG, "merge left number is " + number[i] + " , right number is " + number[j]);
            if (number[i] <= number[j]) {
                candidateArray[temp++] = number[i++];
            } else {
                candidateArray[temp++] = number[j++];
            }
        }
        while (i <= mid) {
            candidateArray[temp] = number[i];
            ++temp;
            ++i;
        }
        while (j <= right) {
            candidateArray[temp] = number[j];
            ++temp;
            ++j;
        }
        temp = 0;
        while (left <= right) {
            number[left] = candidateArray[temp];
            ++temp;
            ++left;
        }
        Log.d(TAG, "sorted temp number is " + Arrays.toString(candidateArray));
        Log.d(TAG, "sorted number is " + Arrays.toString(number));
    }
}

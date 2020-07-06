package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
    private static String TAG = "BucketSort";
    private static int[] number = {15, 28, 33, 16, 49, 10, 34, 61, 27, 36, 57, 68, 71, 16, 87, 90, 134, 243, 8, 51, 57};

    public static int getIndex(int number, int min) {
        return (number - min) / 10;
    }

    public static void bucketSort() {
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
        int bucketSize = maxNumber / 10 - minNumber / 10 + 1;
        List<List<Integer>> bucketNumberList = new ArrayList<>();
        for (int index = 0; index < bucketSize; index++) {
            bucketNumberList.add(new ArrayList<Integer>());
        }
        for (int index = 0; index < size; index++) {
            int numberIndex = getIndex(number[index], minNumber);
            bucketNumberList.get(numberIndex).add(number[index]);
        }
        int originNumberIndex = 0;
        for (int index = 0; index < bucketSize; index++) {
            List<Integer> childNumberList = bucketNumberList.get(index);
            insertSort(childNumberList);
            int childNumberListSize = childNumberList.size();
            for (int childNumberIndex = 0; childNumberIndex < childNumberListSize; childNumberIndex++) {
                number[originNumberIndex++] = childNumberList.get(childNumberIndex);
            }
        }
        Log.e(TAG, "sorted bucket is " + Arrays.toString(number));
    }

    private static void insertSort(List<Integer> bucketChild) {
        int size = bucketChild.size();
        for (int index = 1; index < size; index++) {
            int tempIndex = index - 1;
            int bucketNumber = bucketChild.get(index);
            for (; tempIndex >= 0 && bucketChild.get(tempIndex) > bucketNumber; tempIndex--) {
                bucketChild.set(tempIndex + 1, bucketChild.get(tempIndex));
            }
            bucketChild.set(tempIndex + 1, bucketNumber);
        }
    }
}

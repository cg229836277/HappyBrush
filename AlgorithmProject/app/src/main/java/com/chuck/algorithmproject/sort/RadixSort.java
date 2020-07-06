package com.chuck.algorithmproject.sort;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {
    private static String TAG = "RadixSort";
    private static int[] number = {15, 28, 33, 16, 49, 10, 34, 61, 27, 36, 57, 68, 71, 16, 87, 90, 134, 243, 8, 51, 57};

    private static int getIndex(int number, int mod) {
        return (number / mod) % 10;
    }

    public static void radixSort() {
        int maxNumber = number[0];
        int size = number.length;
        int baseRadix = 1;
        for (int index = 0; index < size; index++) {
            if (number[index] > maxNumber) {
                maxNumber = number[index];
            }
        }
        int bucketNumber = 10;
        int maxBitNumber = String.valueOf(maxNumber).length();
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int index = 0; index < bucketNumber; index++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int index = 0; index < maxBitNumber; index++) {
            for (int index1 = 0; index1 < size; index1++) {
                int bitNumber = getIndex(number[index1], baseRadix);
                bucketList.get(bitNumber).add(number[index1]);
            }
            int numberIndex = 0;
            for (int index2 = 0; index2 < bucketNumber; index2++) {
                List<Integer> curList = bucketList.get(index2);
                int curSize = curList.size();
                if (curSize == 0) {
                    continue;
                }
                for (int curIndex = 0; curIndex < curSize; curIndex++) {
                    number[numberIndex++] = curList.get(curIndex);
                }
                if (index != maxBitNumber - 1) {
                    curList.clear();
                }
            }
            baseRadix *= 10;
        }
        Log.e(TAG, "sorted bucket is " + Arrays.toString(number));
    }
}

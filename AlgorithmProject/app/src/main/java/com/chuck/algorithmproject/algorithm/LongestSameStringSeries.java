package com.chuck.algorithmproject.algorithm;

public class LongestSameStringSeries {
    public static String findLCS(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return null;
        }
        int lengthA = A.length() + 1;
        int lengthB = B.length() + 1;
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();
        int[][] stateArray = new int[lengthA][lengthB];
        int maxLength = 0, maxIndexJ = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (arrayA[i] == arrayB[j]) {
                    stateArray[i + 1][j + 1] = stateArray[i][j] + 1;
                    if (stateArray[i + 1][j + 1] > maxLength) {
                        maxLength = stateArray[i + 1][j + 1];
                        maxIndexJ = j;
                    }
                } else {
                    stateArray[i + 1][j + 1] = 0;
                }
            }
        }
        if (maxLength > 0) {
            return B.substring(maxIndexJ - maxLength + 1, maxIndexJ + 1);
        }
        return null;
    }

    public static int findLongest(String A, int n, String B, int m) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return -1;
        }
        int lengthA = n + 1;
        int lengthB = m + 1;
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();
        int[][] stateArray = new int[lengthA][lengthB];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrayA[i] == arrayB[j]) {
                    stateArray[i + 1][j + 1] = stateArray[i][j] + 1;
                    if (stateArray[i + 1][j + 1] > maxLength) {
                        maxLength = stateArray[i + 1][j + 1];
                    }
                }
            }
        }
        return maxLength;
    }
}

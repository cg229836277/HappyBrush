package com.chuck.algorithmproject.algorithm;

public class LongestCommonStringSeries {
    public int findLCS(String A, int n, String B, int m) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return -1;
        }
        int rowLength = n + 1;
        int columnLength = m + 1;
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        int[][] stateArray = new int[rowLength][columnLength];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (charA[i] == charB[j]) {
                    stateArray[i + 1][j + 1] = stateArray[i][j] + 1;//如果字符相同，那么将当前表格的左上角的值+1填到当前表格中
                } else {
                    //如果字符不相同，那么将当前表格左边或者上边中最大值填到当前表格中
                    stateArray[i + 1][j + 1] = Math.max(stateArray[i][j + 1], stateArray[i + 1][j]);
                }
            }
        }
        return stateArray[n][m];
    }
}

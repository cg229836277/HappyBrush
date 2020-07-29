package com.chuck.algorithmproject.algorithm;

public class LRSOperation1 {
    public static String getMaxLength(String str, int start, int end) {
        int size = str.length();
        int maxSize = 0;
        while (end < size && str.charAt(start) == str.charAt(end)) {
            ++start;
            ++end;
            ++maxSize;
        }
        if (maxSize == 0) {
            return "";
        }
//        String tempStr = str.substring(start,end);
        String result = str.substring(end - maxSize, end);
//        System.out.println("result tempStr result:" + result);
        return result;
    }

    public static String longestDupSubstring(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int size = S.length();
        int maxLength = 0;
        String maxStr = "";
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String tempStr = getMaxLength(S, i, j);
                int tempSize = tempStr.length();
                if (tempSize > maxLength) {
                    maxLength = tempSize;
                    maxStr = tempStr;
                }
            }
        }
        return maxStr;
    }
}

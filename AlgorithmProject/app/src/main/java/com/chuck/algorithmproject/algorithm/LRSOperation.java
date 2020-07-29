package com.chuck.algorithmproject.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//leetcode 1044. 最长重复子串
public class LRSOperation {
    public static int getLRSNumber(String input){
        if(input == null || input.length() == 0){
            System.out.println(-1);
            return -1;
        }
        int size = input.length();
        TreeSet<String> treeSet = new TreeSet<String>();
        for(int index = 0;index < size;index++){
            treeSet.add(input.substring(index));
        }
        List<String> list = new ArrayList<String>(treeSet);

        int index1 = 0,maxLength = 0;
        while(index1 < size - 1){
            int commonSize = 0;
            String str1 = list.get(index1);
            String str2 = list.get(index1 + 1);
            int p = str1.length();
            int q = str2.length();
            int i = Math.min(p,q);
            int index2 = 0;
            while(index2 < i){
                if(str1.charAt(index2) == str2.charAt(index2)) {
                    ++commonSize;
                    if (commonSize > maxLength) {
                        maxLength = commonSize;
                    }
                }
                ++index2;
            }
            ++index1;
        }
        return maxLength;
    }

    class Solution {
        public int maxRepOpt1(String text) {
            if(text == null || text.length() == 0){
                return 0;
            }
            int size = text.length();
            TreeSet<String> set = new TreeSet<String>();
            for(int index= 0;index < size;index++){
                set.add(text.substring(index));
            }
            ArrayList<String> list = new ArrayList<String>(set);
            int max = 0;
            for(int index1 = 0;index1 < size - 1;index1++){
                String str1 = list.get(index1);
                String str2 = list.get(index1 + 1);
                int childSize = Math.min(str1.length(),str2.length());
                int childIndex = 0,maxSize = 0;
                for(;childIndex < childSize;childIndex++){
                    if(str1.charAt(childIndex) == str2.charAt(childIndex)){
                        ++maxSize;
                        if(maxSize > max){
                            max = maxSize;
                        }
                    }
                }
            }
            return max;
        }
    }

    public class Solution1 {
        public String longestDupSubstring(String S) {
            if(S == null || S.length() == 0){
                return "";
            }
            int size = S.length();
            TreeSet<String> set = new TreeSet<String>();
            for(int index= 0;index < size;index++){
                set.add(S.substring(index));
            }
            ArrayList<String> list = new ArrayList<String>(set);
            int max = 0,maxEndIndex = 0;
            String maxStr = null;
            for(int index1 = 0;index1 < size - 1;index1++){
                String str1 = list.get(index1);
                String str2 = list.get(index1 + 1);
                int str1Size = str1.length();
                int str2Size = str2.length();
                String minStr = str1Size > str2Size ? str2:str1;
                int childSize = Math.min(str1Size,str2Size);
                int childIndex = 0,maxSize = 0;
                for(;childIndex < childSize;childIndex++){
                    if(str1.charAt(childIndex) == str2.charAt(childIndex)){
                        ++maxSize;
                        if(maxSize > max){
                            maxStr = minStr;
                            maxEndIndex = childIndex;
                            max = maxSize;
                        }
                    }
                }
            }
            if(maxStr == null || maxStr.length() == 0){
                return "";
            }
            return maxStr.substring(maxEndIndex - max + 1,maxEndIndex + 1);
        }
    }
}

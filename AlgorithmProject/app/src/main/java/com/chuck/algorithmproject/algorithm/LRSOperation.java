package com.chuck.algorithmproject.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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
}

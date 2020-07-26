package com.chuck.algorithmproject.algorithm;

import java.util.PriorityQueue;

public class FindNumberKNumberInArray {
    public static int getNumberKLargest(int k,int[] array){
        int size = array.length;
        for(int i = 0; i < size;i++){
            for(int j = 0;j < size - i - 1;j++){
                if(array[j + 1] < array[j]){
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[size - k];
    }

    public static void main(String input) {
        String[] str = input.replace("[", "").replace("]", "").split(",");
        int[] data = new int[str.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(str[i]);
        }
        int result = getNumberKLargest(3,data);
        System.out.println("result is:" + result);
    }
}

package com.chuck.algorithmproject;


import android.app.Activity;
import android.os.Bundle;

import com.chuck.algorithmproject.algorithm.FindNumberKNumberInArray;
import com.chuck.algorithmproject.algorithm.LRSOperation;
import com.chuck.algorithmproject.algorithm.LastIndexKValue;
import com.chuck.algorithmproject.algorithm.LongestSameStringSeries;
import com.chuck.algorithmproject.algorithm.ReconstructBinaryTree;
import com.chuck.algorithmproject.algorithm.RevertNode;
import com.chuck.algorithmproject.binarytree.BinaryTree;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        BubbleSort.bubbleSort();
//        SelectionSort.selectionSort();
//        InsertSort.insertSort();
//        ShellInsertSort.shellInsertSort();
//        MergeSort.mergeSort();
//        QuickSort.quickSort();
//        HeapSort.heapSort();
//        CountSort.countSort();
//        BucketSort.bucketSort();
//        RadixSort.radixSort();
//        BinaryTree.start();
//        RevertNode.test();
//        ReconstructBinaryTree.main(null);
//        new LastIndexKValue().main();
//        String result = LongestSameStringSeries.findLCS("1AB2345CD","12345EF");
//        FindNumberKNumberInArray.main("[0,0,0,0,2,0,1]");
//        FindNumberKNumberInArray.main("[3,2,1,5,6,4]");
        int number = LRSOperation.getLRSNumber("aaabaaa");
        System.out.println("result int " + number);
    }
}
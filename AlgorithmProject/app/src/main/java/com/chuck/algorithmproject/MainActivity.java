package com.chuck.algorithmproject;


import android.app.Activity;
import android.os.Bundle;

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
        String result = LongestSameStringSeries.findLCS("1AB2345CD","12345EF");
        System.out.println("result is " + result);
    }
}
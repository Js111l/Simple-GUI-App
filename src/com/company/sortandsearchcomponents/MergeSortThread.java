package com.company.sortandsearchcomponents;
import com.company.algorithmsimplementations.MergeSort;

import javax.swing.*;

public class MergeSortThread extends Thread {
    private final int[] array;
    private final JTextArea mergeSortArea;
    private final JLabel mergeSortTime;

    public int[] getSortedArray() {
        return array;
    }

    public MergeSortThread(int[] array, JTextArea mergeSortArea, JLabel mergeSortTime) {
        this.array = array;
        this.mergeSortArea = mergeSortArea;
        this.mergeSortTime = mergeSortTime;
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        MergeSort.mergeSort(array, 0, array.length - 1);
        long time = (System.nanoTime() - start);
        StringBuilder sb = new StringBuilder();
        for (int j : array) {
            sb.append(j);
        }
        mergeSortArea.setText((sb.toString()));
        mergeSortTime.setText("Time(ns): " + time);
    }
}
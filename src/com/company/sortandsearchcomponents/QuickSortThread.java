package com.company.sortandsearchcomponents;
import com.company.algorithmsimplementations.QuickSort;
import com.company.appinterface.AppUI;

import javax.swing.*;

public class QuickSortThread extends Thread {
    private final int[] array;
    private final JTextArea quickSortArea;
    private final JLabel quickSortTime;
    private final AppUI appUI;

    public int[] getSortedArray() {
        return array;
    }


    public QuickSortThread(int[] array, JTextArea quickSortArea, JLabel quickSortTime, AppUI appUI) {
        this.array = array;
        this.quickSortArea = quickSortArea;
        this.quickSortTime = quickSortTime;
        this.appUI = appUI;
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        QuickSort.quickSort(array, 0, Integer.parseInt(appUI.getArrayLength().getText()) - 1);
        long time = (System.nanoTime() - start);

        StringBuilder sb = new StringBuilder();
        for (int j : array) {
            sb.append(j);
        }
        quickSortArea.setText(sb.toString());
        quickSortTime.setText("Time(ns): " + time);
    }
}

package com.company.sortandsearchcomponents;
import javax.swing.*;

public class SelectionSortThread extends Thread {

    private final int[] array;
    private final JTextArea selectionSortArea;
    private final JLabel selectionSortTime;

    public int[] getSortedArray() {
        return array;
    }

    public SelectionSortThread(int[] array, JTextArea selectionSortArea, JLabel selectionSortTime) {
        this.array = array;
        this.selectionSortArea = selectionSortArea;
        this.selectionSortTime = selectionSortTime;
    }

    @Override
    public void run() {
        long start = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }

        long time = (System.nanoTime() - start);

        StringBuilder sb = new StringBuilder();

        for (int j : array) {
            sb.append(j);
        }

        selectionSortArea.setText(sb.toString());
        selectionSortTime.setText("Time(ns): " + time);
    }

}

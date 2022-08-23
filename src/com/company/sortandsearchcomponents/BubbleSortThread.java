package com.company.sortandsearchcomponents;


import javax.swing.*;

public class BubbleSortThread extends Thread {

    private final int[] array;
    private final JTextArea bubbleSortArea;
    private final JLabel bubbleSortTime;

    public int[] getSortedArray() {
        return array;
    }


    public BubbleSortThread(int[] arr1, JTextArea bubbleSortArea, JLabel bubbleSortTime) {
        this.array = arr1;
        this.bubbleSortArea = bubbleSortArea;
        this.bubbleSortTime = bubbleSortTime;
    }

    @Override
    public void run() {

        long start = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        long time = (System.nanoTime() - start);

        StringBuilder sb = new StringBuilder();

        for (int j : array) {
            sb.append(j);
        }

        bubbleSortArea.setText(sb.toString());
        bubbleSortTime.setText("Time(ns): " + time);
    }

}
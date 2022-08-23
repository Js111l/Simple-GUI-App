package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;


public class Main {

    public static void main(String[] args) {
        App app = new App();
    }
}


class App extends JFrame implements ActionListener {

    JButton generuj;
    JTextArea field;
    JTextField ilosc;
    JTextField min;
    JTextField max;
    JLabel labelMin;
    JLabel labelMax;
    JLabel labelIlosc;
    JLabel sortowanie;
    JLabel bubblesort;
    JTextArea bubblesortArea;
    JLabel selectionsort;
    JTextArea selectionsortArea;
    JLabel quicksort;
    JTextArea quicksortArea;
    JLabel mergesort;
    JTextArea mergesortArea;
    JLabel czasBubblesort;
    JLabel czasQuicksor;
    JLabel czasSelectionsort;
    JLabel czasMergesort;
    JButton sortujBubblesort;
    JButton sortujSelectionsort;
    JButton sortujQuicksort;
    JButton sortujMergesort;


    JLabel wyszukiwanie;
    JButton szukaj;
    JTextArea szukanaLiczba;
    JTextArea pozycjaWCiągu;
    JComboBox<String> wybierzMetodeSortowania;
    int setSearchMethod;

    int[] ciąg;
    int[] arr1;


    App() {
        generuj = new JButton();
        generuj.setText("Generuj");
        generuj.setBounds(450, 30, 100, 30);
        generuj.setFocusable(true);
        generuj.addActionListener(this);

        field = new JTextArea();
        field.setBounds(290, 30, 150, 30);
        field.setEditable(false);


        min = new JTextField();
        min.setBounds(40, 30, 40, 20);
        min.setEditable(true);

        labelMin = new JLabel();
        labelMin.setBounds(10, 32, 30, 15);
        labelMin.setText("Min: ");
        labelMin.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(labelMin);

        max = new JTextField();
        max.setBounds(120, 30, 40, 20);
        max.setEditable(true);

        labelMax = new JLabel();
        labelMax.setBounds(90, 32, 30, 15);
        labelMax.setText("Max: ");
        labelMax.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(labelMax);

        ilosc = new JTextField();
        ilosc.setBounds(210, 30, 40, 20);
        ilosc.setEditable(true);

        labelIlosc = new JLabel();
        labelIlosc.setBounds(170, 32, 33, 15);
        labelIlosc.setText("Ilość: ");
        labelIlosc.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(labelIlosc);


        sortowanie = new JLabel();
        sortowanie.setBounds(40, 100, 150, 60);
        sortowanie.setText("Sortowanie: ");
        sortowanie.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(sortowanie);

        bubblesort = new JLabel();
        bubblesort.setBounds(50, 130, 90, 60);
        bubblesort.setText("bubblesort: ");
        bubblesort.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(bubblesort);

        bubblesortArea = new JTextArea();
        bubblesortArea.setBounds(200, 145, 200, 30);
        bubblesortArea.setVisible(true);
        this.add(bubblesortArea);

        czasBubblesort = new JLabel();
        czasBubblesort.setBounds(480, 145, 120, 30);
        czasBubblesort.setText("Czas(ns): ");
        this.add(czasBubblesort);

        sortujBubblesort = new JButton();
        sortujBubblesort.setBounds(415, 145, 60, 30);
        sortujBubblesort.setText("Sortuj");
        sortujBubblesort.setFont(new Font("Arial", Font.BOLD, 8));
        sortujBubblesort.addActionListener(this);
        this.add(sortujBubblesort);


        selectionsort = new JLabel();
        selectionsort.setBounds(50, 185, 150, 60);
        selectionsort.setText("selectionsort: ");
        selectionsort.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(selectionsort);

        selectionsortArea = new JTextArea();
        selectionsortArea.setBounds(200, 200, 200, 30);
        selectionsortArea.setVisible(true);
        this.add(selectionsortArea);

        czasSelectionsort = new JLabel();
        czasSelectionsort.setBounds(480, 200, 120, 30);
        czasSelectionsort.setText("Czas(ns): ");
        this.add(czasSelectionsort);

        sortujSelectionsort = new JButton();
        sortujSelectionsort.setBounds(415, 200, 60, 30);
        sortujSelectionsort.setText("Sortuj");
        sortujSelectionsort.setFont(new Font("Arial", Font.BOLD, 8));
        sortujSelectionsort.addActionListener(this);
        this.add(sortujSelectionsort);


        quicksort = new JLabel();
        quicksort.setBounds(50, 240, 150, 60);
        quicksort.setText("quicksort: ");
        quicksort.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(quicksort);

        quicksortArea = new JTextArea();
        quicksortArea.setBounds(200, 255, 200, 30);
        quicksortArea.setVisible(true);
        this.add(quicksortArea);

        czasQuicksor = new JLabel();
        czasQuicksor.setBounds(480, 255, 120, 30);
        czasQuicksor.setText("Czas(ns): ");
        this.add(czasQuicksor);


        sortujQuicksort = new JButton();
        sortujQuicksort.setBounds(415, 255, 60, 30);
        sortujQuicksort.setText("Sortuj");
        sortujQuicksort.setFont(new Font("Arial", Font.BOLD, 8));
        sortujQuicksort.addActionListener(this);
        this.add(sortujQuicksort);


        mergesort = new JLabel();
        mergesort.setBounds(50, 295, 150, 60);
        mergesort.setText("mergesort: ");
        mergesort.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(mergesort);

        mergesortArea = new JTextArea();
        mergesortArea.setBounds(200, 310, 200, 30);
        mergesortArea.setVisible(true);
        this.add(mergesortArea);

        czasMergesort = new JLabel();
        czasMergesort.setBounds(480, 310, 120, 30);
        czasMergesort.setText("Czas(ns): ");
        this.add(czasMergesort);


        sortujMergesort = new JButton();
        sortujMergesort.setBounds(415, 310, 60, 30);
        sortujMergesort.setText("Sortuj");
        sortujMergesort.setFont(new Font("Arial", Font.BOLD, 8));
        sortujMergesort.addActionListener(this);
        this.add(sortujMergesort);


        wyszukiwanie = new JLabel();
        wyszukiwanie.setBounds(40, 400, 200, 60);
        wyszukiwanie.setFont(new Font("Arial", Font.BOLD, 20));
        wyszukiwanie.setText("Wyszukiwanie: ");

        szukaj = new JButton();
        szukaj.setBounds(40, 470, 60, 30);
        szukaj.setText("Szukaj");
        szukaj.addActionListener(this);

        szukanaLiczba = new JTextArea();
        szukanaLiczba.setBounds(120, 470, 70, 30);

        pozycjaWCiągu = new JTextArea();
        pozycjaWCiągu.setBounds(220, 470, 70, 30);
        pozycjaWCiągu.setEditable(false);


        wybierzMetodeSortowania = new JComboBox<String>();
        wybierzMetodeSortowania.setBounds(400, 470, 70, 40);
        JButton BinarySearch = new JButton();
        BinarySearch.setText("BinarySearch");
        wybierzMetodeSortowania.addItem("Wybierz");
        wybierzMetodeSortowania.addItem("BinarySearch");
        wybierzMetodeSortowania.addItem("InterpolationSearch");
        wybierzMetodeSortowania.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (wybierzMetodeSortowania.getSelectedItem().toString().equals("BinarySearch")) {
                    JOptionPane.showMessageDialog(null, "Wybrałeś BinarySearch",
                            "informacja", JOptionPane.INFORMATION_MESSAGE);
                    setSearchMethod = 0;


                }
            }
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (wybierzMetodeSortowania.getSelectedItem().toString().equals("InterpolationSearch")) {
                    JOptionPane.showMessageDialog(null, "Wybrałeś InterpolationSearch", "informacja",
                            JOptionPane.INFORMATION_MESSAGE);
                    setSearchMethod = 1;
                }
            }
        });


        this.add(wybierzMetodeSortowania);
        this.add(pozycjaWCiągu);
        this.add(szukanaLiczba);
        this.add(szukaj);
        this.add(wyszukiwanie);
        this.add(generuj);
        this.add(field);
        this.add(ilosc);
        this.add(max);
        this.add(min);

        this.setLayout(null);
        this.setSize(600, 800);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == generuj) {
            ciąg = new int[Integer.parseInt(ilosc.getText())];

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < Integer.parseInt(ilosc.getText()); i++) {
                ciąg[i] = (int) Math.floor((Math.random() * (Integer.parseInt(max.getText()) -
                        Integer.parseInt(min.getText()) + 1) + Integer.parseInt(min.getText())));
            }


            for (int j : ciąg) {
                sb.append(j);
            }

            pozycjaWCiągu.setText("");
            field.setText(sb.toString());

        }

        if (e.getSource() == sortujBubblesort) {
            arr1 = ciąg;
            long start = System.nanoTime();

            for (int i = 0; i < arr1.length; i++) {
                for (int j = i + 1; j < arr1.length; j++) {
                    if (arr1[i] > arr1[j]) {
                        int temp = arr1[j];
                        arr1[j] = arr1[i];
                        arr1[i] = temp;
                    }
                }
            }
            long time = (System.nanoTime() - start);

            StringBuilder sb = new StringBuilder();

            for (int j : arr1) {
                sb.append(j);
            }

            bubblesortArea.setText(sb.toString());
            czasBubblesort.setText("Czas(ns): " + time / 10000);
        }
        if (e.getSource() == sortujSelectionsort) {
            int[] arr2 = ciąg;

            long start = System.nanoTime();

            for (int i = 0; i < arr2.length; i++) {
                int min = i;
                for (int j = i + 1; j < arr2.length; j++) {
                    if (arr2[min] > arr2[j]) {
                        min = j;
                    }
                }
                int temp = arr2[min];
                arr2[min] = arr2[i];
                arr2[i] = temp;
            }

            long time = (System.nanoTime() - start);

            StringBuilder sb = new StringBuilder();

            for (int j : arr2) {
                sb.append(j);
            }

            selectionsortArea.setText(sb.toString());
            czasSelectionsort.setText("Czas(ns): " + time / 10000);

        }
        if (e.getSource() == sortujQuicksort) {
            int[] arr3 = ciąg;
            long start = System.nanoTime();


            QuickSort.quickSort(arr3, 0, Integer.parseInt(ilosc.getText()) - 1);
            long time = (System.nanoTime() - start);

            StringBuilder sb = new StringBuilder();
            for (int j : arr3) {
                sb.append(j);
            }

            quicksortArea.setText(sb.toString());
            czasQuicksor.setText("Czas(ns): " + time / 10000);


        }

        if (e.getSource() == sortujMergesort) {

            int[] arr4 = ciąg;
            long start = System.nanoTime();

            MergeSort.mergeSort(arr4, 0, arr4.length - 1);


            long time = (System.nanoTime() - start);

            StringBuilder sb = new StringBuilder();

            for (int j : arr4) {
                sb.append(j);
            }
            mergesortArea.setText(sb.toString());
            czasMergesort.setText("Czas(ns): " + time / 10000);
        }

        Object[] sortedArrays = {arr1};


        if (e.getSource() == szukaj) {

            int[] methods = {BinarySearch.binarySearch(arr1, 0,
                    arr1.length - 1, Integer.parseInt(szukanaLiczba.getText())),
                    BinarySearch.interpolationSearch(arr1,
                            0, arr1.length - 1, Integer.parseInt(szukanaLiczba.getText()))};

            pozycjaWCiągu.setText(String.valueOf(methods[setSearchMethod]));


        }
    }
}

class BinarySearch {

    static int binarySearch(int[] array, int low, int high, int k) {

        if (high >= low) {
            int mid = low + ((high - low) / 2);
            if (k == array[mid])
                return mid;
            if (k < array[mid])
                return binarySearch(array, low, mid - 1, k);
            else
                return binarySearch(array, mid + 1, high, k);
        }
        return -1;
    }

    static int interpolationSearch(int[] arr, int low, int high, int k) {

        if (arr[low] <= k && k <= arr[high] && low <= high) {
            int pos = low + (
                    ((k - arr[low]) * (high - low)) / (arr[high] - arr[low])
            );
            if (k == arr[pos])
                return pos;
            if (k < arr[pos])
                return interpolationSearch(arr, low, pos - 1, k);
            else
                return interpolationSearch(arr, pos + 1, high, k);
        }
        return -1;
    }

}

class QuickSort {

    static void quickSort(int[] nums, int nizszy, int wyzszy) {

        if (nums.length == 0) {
            return;
        }
        if (nizszy >= wyzszy) {
            return;
        }

        int i = nizszy;
        int j = wyzszy;
        int pivot = nums[nizszy + (wyzszy - nizszy) / 2];

        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (pivot < nums[j]) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (nizszy < j) {
            quickSort(nums, nizszy, j);
        }
        if (wyzszy > i) {
            quickSort(nums, i, wyzszy);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


class MergeSort{

    static void mergeSort(int [] array,int low,int high){

        if(high<=low){
            return;
        }
        int mid=(low+high)/2;

        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int low, int mid,int high) {
        int [] leftArray =new int[mid-low+1];
        int [] rightArray =new int[high-mid];

        for(int i=0;i<leftArray.length;i++){
            leftArray[i]=array[i+low];
        }
        for(int i=0;i<rightArray.length;i++){
            rightArray[i]=array[i+mid+1];
        }

        int i=0;
        int j=0;
        int index=low;

        while (i<leftArray.length && j<rightArray.length){
            if(leftArray[i]<rightArray[j]){
                array[index]=leftArray[i];
                index++;
                i++;
            }else {
                array[index]=rightArray[j];
                j++;
                index++;
            }

        }
        while (i<leftArray.length){
            array[index]=leftArray[i];
            i++;
            index++;
        }
        while (j<rightArray.length){
            array[index]=rightArray[j];
            j++;
            index++;
        }

    }
}




package com.company;
import com.company.algorithmsimplementations.BinarySearch;
import com.company.sortandsearchcomponents.*;
import com.company.appinterface.AppUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        App app = new App();
    }
}

class App extends JFrame implements ActionListener {

    private JButton bubbleSortButton;
    private JButton mergeSortButton;
    private JButton selectionSortButton;
    private JButton quickSortButton;

    private JTextArea quickSortArea;
    private JTextArea mergeSortArea;
    private JTextArea selectionSortArea;
    private JTextArea bubbleSortArea;

    private JLabel quickSortTime;
    private JLabel mergeSortTime;
    private JLabel selectionSortTime;
    private JLabel bubbleSortTime;

    private final AppUI appUI;
    private final SearchComponents searchComponents;
    private List<int[]> sortedArrays;
    private int[] array;

    public App() {
        appUI = new AppUI();
        searchComponents = new SearchComponents();
        addAppInterface();
        addSearchingComponents();
        addBubbleSortComponents();
        addSelectionSortComponents();
        addMergeSortComponents();
        addQuicksortComponents();
        addUIComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) throws NumberFormatException {
        if (e.getSource() == appUI.getRefresh()) {
            appUI.getField().setText("");
            appUI.getArrayLength().setText("");
            searchComponents.getIndexInArray().setText("");
            searchComponents.getSearchedNumber().setText("");
            clearTextAreas();
        }
        try {
            if (e.getSource() == appUI.getGenerate()) {
                if (appUI.getArrayLength().getText().isEmpty()||inputMismatchOccur(appUI.getArrayLength().getText())) {
                    throw new InputMismatchException();
                }
                    clearTextAreas();
                    if (BigInteger.valueOf(Long.parseLong(appUI.getArrayLength().getText())).
                            compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0) {
                        throw new NumberFormatException();
                    }
                    array = new int[Integer.parseInt(appUI.getArrayLength().getText())];
                    GenerateThread thread = new GenerateThread(array, appUI, searchComponents);
                    thread.start();
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Inserted number is too large! Acceptable length range: 1-2,147,483,647", "error", JOptionPane.ERROR_MESSAGE);
        }
        catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "Please, insert required data", "error", JOptionPane.ERROR_MESSAGE);
        }


        try {
            if (e.getSource() == bubbleSortButton) {
                if (appUI.getArrayLength().getText().isEmpty()) {
                    throw new Exception();
                }
                startSorting(new BubbleSortThread(array, bubbleSortArea, bubbleSortTime));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "You need to generate data first in order to sort it.", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == selectionSortButton) {
                if (appUI.getArrayLength().getText().isEmpty()) {
                    throw new Exception();
                }
                startSorting(new SelectionSortThread(array, selectionSortArea, selectionSortTime));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "You need to generate data first in order to sort it.", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == quickSortButton) {
                if (appUI.getArrayLength().getText().isEmpty()) {
                    throw new Exception();
                }
                startSorting(new QuickSortThread(array, quickSortArea, quickSortTime, appUI));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "You need to generate data first in order to sort it.", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == mergeSortButton) {
                if (appUI.getArrayLength().getText().isEmpty()) {
                    throw new Exception();
                }
                startSorting(new MergeSortThread(array, mergeSortArea, mergeSortTime));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "You need to generate data first in order to sort it.", "Warning", JOptionPane.ERROR_MESSAGE);
        }

        List<int[]> arrayForSearch = new ArrayList<>();
        int counter = -1;

        for (int[] array : sortedArrays
        ) {
            if (array.length > 1) {
                arrayForSearch.add(array);
                counter++;
            }
        }

        try {
            if (e.getSource() == searchComponents.getSearch()) {
                if (counter == -1) {
                    throw new Exception();
                }
                    if (searchComponents.getSearchedNumber().getText().isEmpty()) {
                        throw new InputMismatchException();
                    }
                    int[] methods = {BinarySearch.binarySearch(arrayForSearch.get(0), 0,
                            array.length - 1, Integer.parseInt(searchComponents.getSearchedNumber().getText())),
                            BinarySearch.interpolationSearch(arrayForSearch.get(0),
                                    0, array.length - 1, Integer.parseInt(searchComponents.getSearchedNumber().getText()))};
                               searchComponents.getIndexInArray().setText(String.valueOf(methods[searchComponents.getSearchMethodController()]));
                }

        }
        catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please, insert the number you want to search", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "BinarySearch and InterpolationSearch works only on sorted arrays!");
        }
    }




    private boolean inputMismatchOccur(String text) {
        for (int i = 0; i < text.length(); i++) {
            if(!Character.isDigit(text.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public void startSorting(Thread thread) {
        thread.start();
        addSortedArrayToList(thread);
    }

    private void addSortedArrayToList(Thread thread) {
        String threadClass=thread.getClass().getSimpleName();
        if (threadClass.equals(BubbleSortThread.class.getSimpleName())) {
            sortedArrays.add(new BubbleSortThread(array, bubbleSortArea, bubbleSortTime).getSortedArray());
        }
        if (threadClass.equals(MergeSortThread.class.getSimpleName())) {
            sortedArrays.add(new MergeSortThread(array, mergeSortArea, mergeSortTime).getSortedArray());
        }
        if (threadClass.equals(QuickSortThread.class.getSimpleName())) {
            sortedArrays.add(new QuickSortThread(array, mergeSortArea, mergeSortTime,appUI).getSortedArray());
        }
        if (threadClass.equals(SelectionSortThread.class.getSimpleName())) {
            sortedArrays.add(new SelectionSortThread(array, mergeSortArea, mergeSortTime).getSortedArray());
        }
    }

    private void clearTextAreas() {
        sortedArrays = new ArrayList<>();
        bubbleSortArea.setText("");
        bubbleSortTime.setText("Time(ns): ");
        quickSortArea.setText("");
        quickSortTime.setText("Time(ns): ");
        selectionSortArea.setText("");
        selectionSortTime.setText("Time(ns): ");
        mergeSortArea.setText("");
        mergeSortTime.setText("Time(ns): ");
    }

    private void addAppInterface() {
        this.appUI.addAppGeneralUI();
    }

    private void addSearchingComponents() {
        this.searchComponents.addSearchingComponents();
    }

    private void addUIComponents() {
        searchComponents.getSearch().addActionListener(this);
        appUI.getGenerate().addActionListener(this);
        appUI.getRefresh().addActionListener(this);
        this.add(searchComponents.getSearch());
        this.add(appUI.getSorting());
        this.add(searchComponents.getIndexInArrayOutputLabel());
        this.add(searchComponents.getNumberToSearchInputLabel());
        this.add(appUI.getLabelArrayLength());
        this.add(searchComponents.getChooseMethodOfSorting());
        this.add(searchComponents.getIndexInArray());
        this.add(searchComponents.getSearchedNumber());
        this.add(searchComponents.getSearch());
        this.add(searchComponents.getSearching());
        this.add(appUI.getGenerate());
        this.add(appUI.getRefresh());
        this.add(appUI.getArrayLength());
        this.getContentPane().setBackground(Color.lightGray);
        this.setSize(650, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.add(appUI.getField());
        this.setVisible(true);
    }


    private void addQuicksortComponents() {
        QuicksortComponents quicksortComponents = new QuicksortComponents();
        quicksortComponents.setTextLabel();
        this.add(quicksortComponents.getTextLabel());
        quicksortComponents.setTextArea();
        this.add(quicksortComponents.getSortingMethodTextArea());
        quicksortComponents.setTime();
        this.add(quicksortComponents.getSortingMethodTime());
        quicksortComponents.setSortButton();
        quicksortComponents.getSortButton().addActionListener(this);
        this.add(quicksortComponents.getSortButton());
        quickSortButton = quicksortComponents.getSortButton();
        quickSortArea = quicksortComponents.getSortingMethodTextArea();
        quickSortTime = quicksortComponents.getSortingMethodTime();
    }

    private void addSelectionSortComponents() {
        SelectionSortComponents selectionSortComponents = new SelectionSortComponents();
        selectionSortComponents.setTextArea();
        this.add(selectionSortComponents.getSortingMethodTextArea());
        selectionSortComponents.setTextLabel();
        this.add(selectionSortComponents.getTextLabel());
        selectionSortComponents.setSortButton();
        this.add(selectionSortComponents.getSortButton());
        selectionSortComponents.setTime();
        selectionSortComponents.getSortButton().addActionListener(this);
        this.add(selectionSortComponents.getSortingMethodTime());
        selectionSortButton = selectionSortComponents.getSortButton();
        selectionSortArea = selectionSortComponents.getSortingMethodTextArea();
        selectionSortTime = selectionSortComponents.getSortingMethodTime();
    }

    private void addBubbleSortComponents() {
        BubbleSortComponents bubbleSortComponents = new BubbleSortComponents();
        bubbleSortComponents.setTextLabel();
        this.add(bubbleSortComponents.getTextLabel());
        bubbleSortComponents.setTextArea();
        this.add(bubbleSortComponents.getSortingMethodTextArea());
        bubbleSortComponents.setTime();
        this.add(bubbleSortComponents.getSortingMethodTime());
        bubbleSortComponents.setSortButton();
        bubbleSortComponents.getSortButton().addActionListener(this);
        this.add(bubbleSortComponents.getSortButton());
        bubbleSortButton = bubbleSortComponents.getSortButton();
        bubbleSortArea = bubbleSortComponents.getSortingMethodTextArea();
        bubbleSortTime = bubbleSortComponents.getSortingMethodTime();
    }

    private void addMergeSortComponents() {
        MergeSortComponents mergeSortComponents = new MergeSortComponents();
        mergeSortComponents.setTextArea();
        this.add(mergeSortComponents.getSortingMethodTextArea());
        mergeSortComponents.setTextLabel();
        this.add(mergeSortComponents.getTextLabel());
        mergeSortComponents.setTime();
        this.add(mergeSortComponents.getSortingMethodTime());
        mergeSortComponents.setSortButton();
        mergeSortComponents.getSortButton().addActionListener(this);
        this.add(mergeSortComponents.getSortButton());
        mergeSortButton = mergeSortComponents.getSortButton();
        mergeSortArea = mergeSortComponents.getSortingMethodTextArea();
        mergeSortTime = mergeSortComponents.getSortingMethodTime();
    }
}

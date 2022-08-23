package com.company.sortandsearchcomponents;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.Objects;

public class SearchComponents {
    private JLabel searching;
    private JButton search;
    private JTextArea searchedNumber;
    private JTextArea indexInArray;
    private JComboBox<String> chooseMethodOfSorting;
    private JLabel indexInArrayOutputLabel;
    private JLabel numberToSearchInputLabel;
    private int searchMethodController;

    public JLabel getSearching() {
        return searching;
    }

    public JButton getSearch() {
        return search;
    }

    public JTextArea getSearchedNumber() {
        return searchedNumber;
    }

    public JTextArea getIndexInArray() {
        return indexInArray;
    }

    public JComboBox<String> getChooseMethodOfSorting() {
        return chooseMethodOfSorting;
    }

    public JLabel getIndexInArrayOutputLabel() {
        return indexInArrayOutputLabel;
    }

    public JLabel getNumberToSearchInputLabel() {
        return numberToSearchInputLabel;
    }

    public int getSearchMethodController() {
        return searchMethodController;
    }

    public void addSearchingComponents() {
        searching = new JLabel();
        searching.setBounds(40, 400, 200, 60);
        searching.setFont(new Font("Arial", Font.BOLD, 20));
        searching.setText("Searching: ");

        search = new JButton();
        search.setBounds(40, 470, 80, 30);
        search.setText("Search");

        searchedNumber = new JTextArea();
        searchedNumber.setBounds(180, 470, 70, 30);

        indexInArray = new JTextArea();
        indexInArray.setBounds(300, 470, 70, 30);
        indexInArray.setEditable(false);

        indexInArrayOutputLabel = new JLabel();
        indexInArrayOutputLabel.setText("Index in array: ");
        indexInArrayOutputLabel.setBounds(280, 440, 90, 30);

        numberToSearchInputLabel = new JLabel();
        numberToSearchInputLabel.setText("Search for a number: ");
        numberToSearchInputLabel.setBounds(140, 440, 130, 30);


        chooseMethodOfSorting = new JComboBox<>();
        chooseMethodOfSorting.setBounds(400, 470, 150, 30);
        JButton BinarySearch = new JButton();


        BinarySearch.setText("BinarySearch");
        chooseMethodOfSorting.addItem("BinarySearch");
        chooseMethodOfSorting.addItem("InterpolationSearch");
        chooseMethodOfSorting.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (Objects.requireNonNull(chooseMethodOfSorting.getSelectedItem()).toString().equals("BinarySearch")) {
                    searchMethodController = 0;
                }
            }
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (Objects.requireNonNull(chooseMethodOfSorting.getSelectedItem()).toString().equals("InterpolationSearch")) {
                    searchMethodController = 1;
                }
            }
        });
    }
}

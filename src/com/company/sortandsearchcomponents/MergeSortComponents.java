package com.company.sortandsearchcomponents;
import javax.swing.*;
import java.awt.*;


public class MergeSortComponents extends SortingComponents {

    @Override
    public JButton getSortButton() {
        return MergeSortComponents.sortButton;
    }

    @Override
    public JLabel getTextLabel() {
        return super.getTextLabel();
    }

    @Override
    public JTextArea getSortingMethodTextArea() {
        return super.getSortingMethodTextArea();
    }

    @Override
    public JLabel getSortingMethodTime() {
        return super.getSortingMethodTime();
    }

    @Override
    public void setTextLabel() {

        MergeSortComponents.textLabel = new JLabel();
        MergeSortComponents.textLabel.setBounds(50, 295, 160, 60);
        MergeSortComponents.textLabel.setText("MergeSort: ");
        MergeSortComponents.textLabel.setFont(new Font("Arial", Font.BOLD, 15));
    }

    @Override
    public void setTextArea() {
        super.setTextArea();
        MergeSortComponents.sortingMethodTextArea.setBounds(200, 310, 200, 30);
        MergeSortComponents.sortingMethodTextArea.setEditable(false);
    }

    @Override
    public void setTime() {
        super.setTime();
        MergeSortComponents.sortingMethodTime.setBounds(480, 310, 120, 30);
        MergeSortComponents.sortingMethodTime.setText("Time(ns): ");
    }

    @Override
    public void setSortButton() {
        super.setSortButton();
        MergeSortComponents.sortButton.setBounds(415, 310, 60, 30);
        MergeSortComponents.sortButton.setText("Sort");
        MergeSortComponents.sortButton.setFont(new Font("Arial", Font.BOLD, 8));
    }


}



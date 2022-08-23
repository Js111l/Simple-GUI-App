package com.company.sortandsearchcomponents;

import javax.swing.*;
import java.awt.*;

public class BubbleSortComponents extends SortingComponents {

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
    public JButton getSortButton() {
        return BubbleSortComponents.sortButton;
    }

    @Override
    public void setTextLabel() {
        super.setTextLabel();
        BubbleSortComponents.textLabel.setBounds(50, 130, 100, 60);
        BubbleSortComponents.textLabel.setText("BubbleSort: ");
        BubbleSortComponents.textLabel.setFont(new Font("Arial", Font.BOLD, 15));

    }

    @Override
    public void setTextArea() {
        super.setTextArea();
        BubbleSortComponents.sortingMethodTextArea.setBounds(200, 145, 200, 30);
        BubbleSortComponents.sortingMethodTextArea.setEditable(false);
    }

    @Override
    public void setTime() {
        super.setTime();
        BubbleSortComponents.sortingMethodTime.setBounds(480, 145, 120, 30);
        BubbleSortComponents.sortingMethodTime.setText("Time(ns): ");
    }

    @Override
    public void setSortButton() {
        super.setSortButton();
        BubbleSortComponents.sortButton.setBounds(415, 145, 60, 30);
        BubbleSortComponents.sortButton.setText("Sort");
        BubbleSortComponents.sortButton.setFont(new Font("Arial", Font.BOLD, 8));
    }
}

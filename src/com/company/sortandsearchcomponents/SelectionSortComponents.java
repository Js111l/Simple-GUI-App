package com.company.sortandsearchcomponents;

import javax.swing.*;
import java.awt.*;

public class SelectionSortComponents extends SortingComponents {

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
        return SelectionSortComponents.sortButton;
    }

    @Override
    public void setTextLabel() {
        super.setTextLabel();
        SelectionSortComponents.textLabel.setBounds(50, 185, 150, 60);
        SelectionSortComponents.textLabel.setText("SelectionSort: ");
        SelectionSortComponents.textLabel.setFont(new Font("Arial", Font.BOLD, 15));
    }

    @Override
    public void setTextArea() {
        super.setTextArea();
        SelectionSortComponents.sortingMethodTextArea.setBounds(200, 200, 200, 30);
        SelectionSortComponents.sortingMethodTextArea.setEditable(false);
    }

    @Override
    public void setTime() {
        super.setTime();
        SelectionSortComponents.sortingMethodTime.setBounds(480, 200, 120, 30);
        SelectionSortComponents.sortingMethodTime.setText("Time(ns): ");
    }

    @Override
    public void setSortButton() {
        super.setSortButton();
        SelectionSortComponents.sortButton.setText("Sort");
        SelectionSortComponents.sortButton.setBounds(415, 200, 60, 30);
        SelectionSortComponents.sortButton.setBounds(415, 200, 60, 30);
        SelectionSortComponents.sortButton.setFont(new Font("Arial", Font.BOLD, 8));
    }
}

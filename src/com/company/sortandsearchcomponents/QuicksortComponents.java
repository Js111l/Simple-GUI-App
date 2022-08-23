package com.company.sortandsearchcomponents;
import javax.swing.*;
import java.awt.*;

public class QuicksortComponents extends SortingComponents {

    @Override
    public void setTextLabel() {
        super.setTextLabel();
        QuicksortComponents.textLabel.setBounds(50, 240, 150, 60);
        QuicksortComponents.textLabel.setText("QuickSort: ");
        QuicksortComponents.textLabel.setFont(new Font("Arial", Font.BOLD, 15));
    }

    @Override
    public void setTextArea() {
        super.setTextArea();
        QuicksortComponents.sortingMethodTextArea.setBounds(200, 255, 200, 30);
        QuicksortComponents.sortingMethodTextArea.setEditable(false);
    }

    @Override
    public void setTime() {
        super.setTime();
        QuicksortComponents.sortingMethodTime.setBounds(480, 255, 120, 30);
        QuicksortComponents.sortingMethodTime.setText("Time(ns): ");
    }

    @Override
    public void setSortButton() {
        super.setSortButton();
        QuicksortComponents.sortButton.setBounds(415, 255, 60, 30);
        QuicksortComponents.sortButton.setText("Sort");
        QuicksortComponents.sortButton.setFont(new Font("Arial", Font.BOLD, 8));
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
    public JButton getSortButton() {
        return QuicksortComponents.sortButton;
    }
}

package com.company.sortandsearchcomponents;
import javax.swing.*;

public abstract class SortingComponents {
    protected static JLabel textLabel;
    protected static JTextArea sortingMethodTextArea;
    protected static JLabel sortingMethodTime;
    protected static JButton sortButton;
    protected JLabel getTextLabel() {
        return textLabel;
    }
    protected JTextArea getSortingMethodTextArea() {
        return sortingMethodTextArea;
    }
    protected JLabel getSortingMethodTime() {
        return sortingMethodTime;
    }
    protected JButton getSortButton() {
        return sortButton;
    }
    protected void setTextLabel(){textLabel=new JLabel();}
    protected void setTextArea() {sortingMethodTextArea = new JTextArea();}
    protected void setTime() {
        sortingMethodTime = new JLabel();
    }
    protected void setSortButton() {
        sortButton = new JButton();
    }


}

package com.company.appinterface;


import javax.swing.*;
import java.awt.*;

public class AppUI {

    private JButton generate;
    private JButton refresh;
    private JTextArea field;
    private JTextField arrayLength;
    private JLabel labelArrayLength;
    private JLabel sorting;

    public void addAppGeneralUI() {
        this.setRefresh(new JButton());
        this.getRefresh().setText("Refresh");
        this.getRefresh().setBounds(50, 30, 100, 30);
        this.getRefresh().setFocusable(true);

        this.setGenerate(new JButton());
        this.getGenerate().setText("Generate");
        this.getGenerate().setBounds(450, 30, 100, 30);
        this.getGenerate().setFocusable(true);

        setField(new JTextArea());
        getField().setEditable(false);
        getField().setBounds(290, 30, 150, 30);

        setArrayLength(new JTextField());
        getArrayLength().setBounds(220, 30, 40, 20);
        getArrayLength().setEditable(true);

        setLabelArrayLength(new JLabel());
        getLabelArrayLength().setBounds(170, 32, 50, 15);
        getLabelArrayLength().setText("Length: ");
        getLabelArrayLength().setFont(new Font("Arial", Font.BOLD, 12));

        setSorting(new JLabel());
        getSorting().setBounds(40, 100, 150, 60);
        getSorting().setText("Sorting: ");
        getSorting().setFont(new Font("Arial", Font.BOLD, 20));

    }

    public JButton getRefresh() {
        return refresh;
    }

    public void setRefresh(JButton refresh) {
        this.refresh = refresh;
    }

    public JTextArea getField() {
        return field;
    }

    public void setField(JTextArea field) {
        this.field = field;
    }

    public JTextField getArrayLength() {
        return arrayLength;
    }

    public void setArrayLength(JTextField arrayLength) {
        this.arrayLength = arrayLength;
    }

    public JLabel getLabelArrayLength() {
        return labelArrayLength;
    }

    public void setLabelArrayLength(JLabel labelArrayLength) {
        this.labelArrayLength = labelArrayLength;
    }

    public JButton getGenerate() {
        return generate;
    }

    public void setGenerate(JButton generate) {
        this.generate = generate;
    }

    public JLabel getSorting() {
        return sorting;
    }

    public void setSorting(JLabel sorting) {
        this.sorting = sorting;
    }
}

package com.company.sortandsearchcomponents;
import com.company.appinterface.AppUI;

public class GenerateThread extends Thread {

    private final int[] array;
    private final AppUI appUI;
    private final SearchComponents searchComponents;

    public GenerateThread(int[] array, AppUI appUI, SearchComponents searchComponents) {
        this.array = array;
        this.appUI = appUI;
        this.searchComponents = searchComponents;
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Integer.parseInt(appUI.getArrayLength().getText()); i++) {
            array[i] = (int) Math.floor((Math.random() * (9 - 0 + 1) + 0));
        }

        for (int j : array) {
            sb.append(j);
        }

        searchComponents.getIndexInArray().setText("");
        appUI.getField().setText(sb.toString());
    }
}
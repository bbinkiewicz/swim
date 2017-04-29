package com.example.pc.swimapp3.beans;

import java.io.Serializable;


public class ListItem implements Serializable {

    private int headerSize;
    private int backgroundColor;
    private int headerColor;
    private String headerText;
    public ListItem(){}

    public ListItem(int headerSize, int backgroundColor, int headerColor, String headerText) {
        this.headerSize = headerSize;
        this.backgroundColor = backgroundColor;
        this.headerColor = headerColor;
        this.headerText = headerText;
    }

    public int getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(int headerSize) {
        this.headerSize = headerSize;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getHeaderColor() {
        return headerColor;
    }

    public void setHeaderColor(int headerColor) {
        this.headerColor = headerColor;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }
}

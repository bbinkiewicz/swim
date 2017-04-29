package com.example.pc.swimapp3.beans;

import java.io.Serializable;


public class ListItem implements Serializable {

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    private int backgroundColor;
    private int headerColor;
    private String headerText;
    private int ratingValue;
    public ListItem(){}

    public ListItem(String status, int backgroundColor, int headerColor, String headerText, int rating) {
        this.status = status;
        this.backgroundColor = backgroundColor;
        this.headerColor = headerColor;
        this.headerText = headerText;
        this.ratingValue = rating;
    }

    public String getStatus() {
        return status;
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

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }
}

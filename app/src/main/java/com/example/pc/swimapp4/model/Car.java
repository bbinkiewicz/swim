package com.example.pc.swimapp4.model;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by PC on 2017-05-10.
 */

public class Car extends RealmObject {

    @Required
    private String brand;
    @Required
    private String model;
    @Required
    private String horsePower;

    public Car(){}

    public Car(String brand, String model, String horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }
}

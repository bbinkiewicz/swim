package com.example.pc.swimapp4.model;

import io.realm.RealmObject;
import io.realm.annotations.Required;


public class Truck extends RealmObject {
    @Required
    private String brand;
    @Required
    private String model;
    @Required
    private String capacity;

    public Truck(){}

    public Truck(String brand, String model, String capacity) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}

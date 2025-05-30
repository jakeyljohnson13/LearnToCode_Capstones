package com.pluralsight.models;

public class Chip extends MenuItem{
    private String name;
    private double price;

    public Chip(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price = 1.5;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

package com.pluralsight.models;

public class Drink extends MenuItem{
    private String name;
    private String size;
    private double price;

    public Drink(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        double price = 0.0;
        if (size.equalsIgnoreCase("Small")){
            price = 2.0;
        }
        else if (size.equalsIgnoreCase("Medium")){
            price = 2.5;
        } else if (size.equalsIgnoreCase("Large")) {
            price = 3.0;
        }
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return size + " " + name + "($" + price + ")";
    }
}

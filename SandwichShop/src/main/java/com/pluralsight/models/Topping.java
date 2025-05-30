package com.pluralsight.models;

public class Topping{
    private String name;
    private double price;
    private String type;
    private boolean extra;

    public Topping(String name, double price, String type, boolean extra) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setPremium(String type) {
        this.type = type;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public double getPrice(int size) {
        if (type.equalsIgnoreCase("included")) {
            price = 0.0;
            return price;
    }

    double basePrice = type.equalsIgnoreCase("cheese") ? 0.75 : 1.0;
    double extraPrice = type.equalsIgnoreCase("cheese") ? 0.3 : 0.5;

    price = calculatePrice(size, extra ? extraPrice : basePrice);
    return price;
    }

    private double calculatePrice(int size, double basePrice) {
        return switch (size) {
            case 4 -> basePrice;
            case 8 -> basePrice * 2;
            case 12 -> basePrice * 3;
            default -> 0.0;
        };
    }
    @Override
    public String toString() {
        return name + " (" + type + ", " + (extra ? "Extra" : "Base") + ", $" + price + ")";
    }

}

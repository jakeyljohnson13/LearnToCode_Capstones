package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends MenuItem{
    private int size;
    private String bread;
    private boolean toasted;

    public Sandwich(int size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }


    List<Topping> toppings = new ArrayList<>();
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public List<Topping> getToppings(){
        return toppings;
    }

    @Override
    public double getPrice() {
        double price = 0.0;
        for (Topping t : toppings){
            price += t.getPrice(size);
        }
        switch (size){
            case 4: price += 5.5;
            break;
            case 8: price += 7;
            break;
            case 12: price += 8.5;
            break;
        }
        return price;
    }
}

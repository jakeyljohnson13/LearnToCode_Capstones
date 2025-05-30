package com.pluralsight.util;
import com.pluralsight.models.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void getRecipt(Order order){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String formattedDate = now.format(formatter);
        String filename = formattedDate + ".txt";

        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            bufferedWriter.write("JJ's Sandwiches Order Receipt\n");
            bufferedWriter.write("-------------------------------------");
            for (MenuItem item : order.getOrder()){
                if (item instanceof Sandwich){
                    Sandwich sandwich = (Sandwich) item;
                    bufferedWriter.write("\nSandwich with: " + sandwich.getBread() + " bread, Size: " + sandwich.getSize() + " Toasted: " + (sandwich.isToasted() ? "Yes\n" : "No\n") );
                    bufferedWriter.write("Toppings:\n");
                    for (Topping topping : sandwich.getToppings()){
                        bufferedWriter.write("     " + topping + " --- " + topping.getPrice(sandwich.getSize()) + "\n");
                    }
                    bufferedWriter.write("Price: $" + String.format("%.2f",sandwich.getPrice()) + "\n");
                }
                if (item instanceof Drink){
                    Drink drink = (Drink) item;
                    bufferedWriter.write(drink.getSize() + " " + drink.getName() + " --- $" + drink.getPrice() + "\n");
                }
                if (item instanceof Chip){
                    Chip chip = (Chip) item;
                    bufferedWriter.write(chip.getName() + " --- $" + chip.getPrice() + "\n");
                }
            }
            bufferedWriter.write("Your total is $" + order.getTotal());
            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println("Error writing receipt " + e.getMessage());
        }
    }

}

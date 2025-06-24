package com.pluralsight.ui;
import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean closeApp = false;
        while (!closeApp) {
            System.out.println("Welcome to JJ's Sandwiches! Please select an option below.\n 1-New Order\n 0-Exit");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 0) {
                System.out.println("Exiting...");
                closeApp = true;
            } else if (input == 1) {
                System.out.println("Great! Let's get started on your new order!");
                orderScreen();
            } else System.out.println("Invalid Entry. Please try again.");
        }
    }

    public static void orderScreen() {
        boolean exitOrder = false;
        Scanner scanner = new Scanner(System.in);
        Order order = new Order(new ArrayList<>());
        while (!exitOrder) {
            System.out.println("Please select an option:\n1-Add Sandwich\n2-Add Drink\n3-Add Chips\n4-Checkout\n5-Cancel Order");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Let's get you a sandwich!");
                    order.addSandwich();
                    System.out.println("Sandwich added to order.");
                    break;
                case 2:
                    order.addDrink();
                    break;
                case 3:
                    order.addChips();
                    break;
                case 4:
                    System.out.println("Here's a full list of your order:");
                    for (MenuItem items : order.getOrder()) {
                        if (items instanceof Sandwich) {
                            Sandwich sandwich = (Sandwich) items;
                            System.out.println("Sandwich with: " + sandwich.getBread() +
                                    ", Size: " + sandwich.getSize() +
                                    ", Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));

                            System.out.print("Toppings:\n");
                            for (Topping topping : sandwich.getToppings()) {
                                System.out.print("---" + topping + "\n");
                            }
                            System.out.println("\nPrice: $" + sandwich.getPrice());
                        } else if (items instanceof Chip) {
                            Chip chip = (Chip) items;
                            System.out.println(chip.getName() + (" (" + chip.getPrice()) + ")");
                        } else if (items instanceof Drink) {
                            Drink drink = (Drink) items;
                            System.out.println(drink.getSize() + " " + drink.getName() + " $" + items.getPrice());
                        }
                    }
                    System.out.println("--------------------------");
                    System.out.println("Your total is " + order.getTotal());
                    System.out.println("\nDoes the order look correct on the Screen? (Y/N)");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")){
                        System.out.println("Great! Please take your receipt and proceed to the counter.");
                        ReceiptWriter.getRecipt(order);
                    } else if (confirm.equalsIgnoreCase("n")) {
                        System.out.println("Sorry about that. Let's try again.");
                    } else {
                        System.out.println("Invalid entry. Assuming order is incorrect.");
                    }
                    order = null;
                    exitOrder = true;
                    break;
                case 5:
                    System.out.println("Returning to Home Screen...");
                    order = null;
                    exitOrder = true;
            }
        }
    }
}

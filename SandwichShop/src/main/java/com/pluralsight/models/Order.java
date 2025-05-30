package com.pluralsight.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    List<MenuItem> order;
    private double total;

    public Order(List<MenuItem> order) {
        this.order = order;
        this.total = 0.0;
    }

    public void addSandwich() {
        boolean exitSandwich = false;
        Scanner scanner = new Scanner(System.in);
        while (!exitSandwich) {
            int size = 0;
            while (size == 0) {
                System.out.println("Which size sandwich would you like:\n1-4\"\n2-8\"\n3-12\"");
                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Please enter a number 1-3.");
                    continue;
                }
                int lengthOption = scanner.nextInt();
                scanner.nextLine();
                switch (lengthOption) {
                    case 1:
                        size = 4;
                        System.out.println("4\" selected");
                        break;
                    case 2:
                        size = 8;
                        System.out.println("8\" selected.");
                        break;
                    case 3:
                        size = 12;
                        System.out.println("12\" selected.");
                        break;
                    default:
                        System.out.println("Wrong number entered. Please try again.");
                }
            }
            String bread = null;
            while (bread == null) {
                System.out.println("Please tell us what kind of bread:\n1-White\n2-Wheat\n3-Rye\n4-Wrap");
                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Please enter a number 1-3.");
                    continue;
                }
                int breadChoice = scanner.nextInt();
                scanner.nextLine();
                switch (breadChoice) {
                    case 1:
                        bread = "White";
                        System.out.println("White bread selected.");
                        break;
                    case 2:
                        bread = "Wheat";
                        System.out.println("Wheat bread selected.");
                        break;
                    case 3:
                        bread = "Rye";
                        System.out.println("Rye bread selected.");
                        break;
                    case 4:
                        bread = "Wrap";
                        System.out.println("Wrap bread selected.");
                        break;
                    default:
                        System.out.println("Invalid bread entry. Please try again.");
                }
            }
            System.out.println("Would you like your sandwich toasted? (Y/N)");
            boolean toasted = scanner.nextLine().equalsIgnoreCase("Y");
            Sandwich sandwich = new Sandwich(size, bread, toasted);

            boolean addMeat = true;
            Topping baseMeat = null;
            while (addMeat) {
                System.out.println("Please select from the following meat options:\n1-Steak\n2-Ham\n3-Salami\n4-Roast Beef\n5-Chicken\n6-Bacon\n7-Add Extra Meat\n8-Stop adding meat");

                int meatType = scanner.nextInt();
                scanner.nextLine();

                if (meatType >= 1 && meatType <= 6) {{
                        if (baseMeat == null) {
                            if (sandwich.getSize() == 4){
                                baseMeat = new Topping(getMeatName(meatType), 1.0, "meat", false);
                            } else if (sandwich.getSize() == 8){
                                baseMeat = new Topping(getMeatName(meatType), 2.0, "meat", false);
                            } else if (sandwich.getSize() == 12) {
                                baseMeat = new Topping(getMeatName(meatType), 3.0, "meat", false);
                            }
                            sandwich.addTopping(baseMeat);
                            System.out.println(baseMeat.getName() + " added as the base meat.");
                        } else {
                            System.out.println("You already have a base meat. Select '7' to add extra meat.");
                        }
                    }
                } else if (meatType == 7) {
                    if (baseMeat == null) {
                        System.out.println("You must select a base meat first.");
                        continue;
                    }
                    System.out.println("Select extra meat to add:\n1-Steak\n2-Ham\n3-Salami\n4-Roast Beef\n5-Chicken\n6-Bacon");

                    int extraMeatChoice = scanner.nextInt();
                    scanner.nextLine();
                    Topping extraMeat = null;
                    if (sandwich.getSize() == 4) {
                        extraMeat = new Topping(getMeatName(extraMeatChoice), 0.5, "meat", true);
                    } else if (sandwich.getSize() == 8) {
                        extraMeat = new Topping(getMeatName(extraMeatChoice), 1.0, "meat", true);
                    } else if (sandwich.getSize() == 12) {
                        extraMeat = new Topping(getMeatName(extraMeatChoice), 1.5, "meat", true);
                    }
                    sandwich.addTopping(extraMeat);
                    System.out.println(extraMeat.getName() + " added as extra meat.");
                } else if (meatType == 8) {
                    System.out.println("Finalizing meat selections...");
                    addMeat = false;
                } else {
                    System.out.println("Invalid selection. Try again.");
                }
            }
            boolean addCheese = true;
            Topping baseCheese = null;
            System.out.println("Would you like to add cheese for an upcharge? Y/N");
            String decideCheese = scanner.nextLine();

            if (decideCheese.equalsIgnoreCase("Y")){
                while (addCheese) {
                    System.out.println("Please select from the following cheese options:\n1-American\n2-Provolone\n3-Cheddar\n4-Swiss\n5-Add Extra Cheese\n6-Stop adding cheese");

                    int cheeseType = scanner.nextInt();
                    scanner.nextLine();

                    if (cheeseType >= 1 && cheeseType <= 4) {
                        if (baseCheese == null) {
                            if (sandwich.getSize() == 4) {
                                baseCheese = new Topping(getCheeseName(cheeseType), 0.75, "cheese", false);
                            } else if (sandwich.getSize() == 8) {
                                baseCheese = new Topping(getCheeseName(cheeseType), 1.5, "cheese", false);
                            } else if (sandwich.getSize() == 12) {
                                baseCheese = new Topping(getCheeseName(cheeseType), 2.25, "cheese", false);
                            }
                            sandwich.addTopping(baseCheese);
                            System.out.println(baseCheese.getName() + " added as the base cheese.");
                        } else {
                            System.out.println("You already have a base cheese. Select '5' to add extra cheese.");
                        }
                    } else if (cheeseType == 5) {
                        if (baseCheese == null) {
                            System.out.println("You must select a base cheese first.");
                            continue;
                        }
                        System.out.println("Select extra cheese to add:\n1-American\n2-Provolone\n3-Cheddar\n4-Swiss");

                        int extraCheeseChoice = scanner.nextInt();
                        scanner.nextLine();
                        Topping extraCheese = null;
                        if (sandwich.getSize() == 4){
                            extraCheese = new Topping(getCheeseName(extraCheeseChoice), 0.3, "cheese", true);
                        } else if (sandwich.getSize() == 8) {
                            extraCheese = new Topping(getCheeseName(extraCheeseChoice), 0.6, "cheese", true);
                        } else if (sandwich.getSize() == 12){
                            extraCheese = new Topping(getCheeseName(extraCheeseChoice), 0.3, "cheese", true);
                        }
                        sandwich.addTopping(extraCheese);
                        System.out.println(extraCheese.getName() + " added as extra cheese.");
                    } else if (cheeseType == 6) {
                        System.out.println("Finalizing cheese selections...");
                        addCheese = false;
                    } else {
                        System.out.println("Invalid selection. Try again.");
                    }
                }
            }
            else System.out.println("No cheese. Continuing...");
            boolean addToppings = true;
            while (addToppings) {
                System.out.println("Please select a topping to add:\n1-Lettuce\n2-Peppers\n3-Onions\n4-Tomatoes\n5-Jalepenos\n6-Cucumbers\n7-Pickles\n8-Guacamole\n9-Mushrooms\n");
                int toppingChoice = scanner.nextInt();
                scanner.nextLine();
                switch (toppingChoice) {
                    case 1:
                        sandwich.addTopping(new Topping("Lettuce", 0.0, "included", false));
                        System.out.println("Lettuce added.");
                        break;
                    case 2:
                        sandwich.addTopping(new Topping("Peppers", 0.0, "included", false));
                        System.out.println("Peppers added.");
                        break;
                    case 3:
                        sandwich.addTopping(new Topping("Onions", 0.0, "included", false));
                        System.out.println("Onions added.");
                        break;
                    case 4:
                        sandwich.addTopping(new Topping("Tomatoes", 0.0, "included", false));
                        System.out.println("Tomatoes added.");
                        break;
                    case 5:
                        sandwich.addTopping(new Topping("Jalepenos", 0.0, "included", false));
                        System.out.println("Jalepenos added.");
                        break;
                    case 6:
                        sandwich.addTopping(new Topping("Cucumber", 0.0, "included", false));
                        System.out.println("Cucumber added.");
                        break;
                    case 7:
                        sandwich.addTopping(new Topping("Pickle", 0.0, "included", false));
                        System.out.println("Pickle added.");
                        break;
                    case 8:
                        sandwich.addTopping(new Topping("Guacamole", 0.0, "included", false));
                        System.out.println("Guacamole added.");
                        break;
                    case 9:
                        sandwich.addTopping(new Topping("Mushroom", 0.0, "included", false));
                        System.out.println("Mushroom added.");
                        break;
                }
                System.out.println("Would you like to add more toppings?\n1-Yes\n2-No");
                int addMore = scanner.nextInt();
                scanner.nextLine();
                if (addMore == 2) {
                    System.out.println("Great! Let's move on.");
                    addToppings = false;
                }
            }
            boolean addSauce = true;
            while (addSauce) {
                System.out.println("What sauces would you like to add?\n0-None\n1-Mayo\n2-Mustard\n3-Ketchup\n4-Ranch\n5-Thousand Island\n6-Vinaigrette\n7-Au Jus");
                int sauceChoice = scanner.nextInt();
                scanner.nextLine();
                switch (sauceChoice) {
                    case 1:
                        sandwich.addTopping(new Topping("Mayo", 0.0, "included", false));
                        System.out.println("Mayo added.");
                        break;
                    case 2:
                        sandwich.addTopping(new Topping("Mustard", 0.0, "included", false));
                        System.out.println("Mustard added.");
                        break;
                    case 3:
                        sandwich.addTopping(new Topping("Ketchup", 0.0, "included", false));
                        System.out.println("Ketchup added.");
                        break;
                    case 4:
                        sandwich.addTopping(new Topping("Ranch", 0.0, "included", false));
                        System.out.println("Ranch added.");
                        break;
                    case 5:
                        sandwich.addTopping(new Topping("Thousand Island", 0.0, "included", false));
                        System.out.println("Thousand island added.");
                        break;
                    case 6:
                        sandwich.addTopping(new Topping("Vinaigrette", 0.0, "included", false));
                        System.out.println("Vinaigrette added.");
                        break;
                    case 7:
                        sandwich.addTopping(new Topping("Au Jus", 0.0, "included", false));
                        System.out.println("Au Jus added.");
                        break;
                    case 0:
                        addSauce = false;
                        break;
                    default:
                        System.out.println("Invalid entry. Please try again.");
                }
                System.out.println("Would you like to add more sauces?\n1-Yes\n2-No");
                int moreSauce = scanner.nextInt();
                scanner.nextLine();
                if (moreSauce == 2) {
                    addSauce = false;
                }
            }
            order.add(sandwich);
            System.out.println("Enter 0 to stop adding sandwiches. Enter any other number to continue.");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Invalid entry. Please enter a number");
                continue;
            }
            int addMoreSandwiches = scanner.nextInt();
            scanner.nextLine();
            if (addMoreSandwiches == 0) {
                System.out.println("Finalizing Sandwich entries...");
                exitSandwich = true;
            }
        }
    }
        public static String getMeatName ( int choice){
            return switch (choice) {
                case 1 -> "Steak";
                case 2 -> "Ham";
                case 3 -> "Salami";
                case 4 -> "Roast Beef";
                case 5 -> "Chicken";
                case 6 -> "Bacon";
                default -> "Unknown";
            };
        }
    public static String getCheeseName ( int choice){
        return switch (choice) {
            case 1 -> "American";
            case 2 -> "Provolone ";
            case 3 -> "Cheddar";
            case 4 -> "Swiss";
            default -> "Unknown";
        };
    }

        public void addDrink () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Can't go wrong with a beverage!");
            boolean exitBeverage = false;
            while (!exitBeverage) {
                System.out.println("Please select a size:\n1-Small\n2-Medium\n3-Large");
                int drinkSize = scanner.nextInt();
                scanner.nextLine();
                String size = "";
                switch (drinkSize) {
                    case 1:
                        size = "Small";
                        System.out.println("Small selected");
                        break;
                    case 2:
                        size = "Medium";
                        System.out.println("Medium Selected");
                        break;
                    case 3:
                        size = "Large";
                        System.out.println("Large selected");
                        break;
                    default:
                        System.out.println("Invalid Selection. Please try again.");
                }
                System.out.println("Please select from the drink options:\n1-Coke\n2-Diet Coke\n3-Sprite\n4-Root beer\n5-Lemonade\n6-Gatorade");
                int drinkChoice = scanner.nextInt();
                scanner.nextLine();
                String name = null;
                while (name == null) {
                    switch (drinkChoice) {
                        case 1:
                            name = "Coke";
                            System.out.println("Coke selected.");
                            break;
                        case 2:
                            name = "Diet Coke";
                            System.out.println("Diet Coke selected.");
                            break;
                        case 3:
                            name = "Sprite";
                            System.out.println("Sprite selected.");
                            break;
                        case 4:
                            name = "Root Beer";
                            System.out.println("Root Beer selected.");
                            break;
                        case 5:
                            name = "Lemonade";
                            System.out.println("Lemonade selected");
                            break;
                        case 6:
                            name = "Gatorade";
                            System.out.println("Gatorade selected.");
                            break;
                        default:
                            System.out.println("Invalid entry. Please try again");
                            break;
                    }
                }
                double price = 0.0;
                if (size.equalsIgnoreCase("Small")) {
                    price = 2.0;
                } else if (size.equalsIgnoreCase("Medium")) {
                    price = 2.5;
                } else if (size.equalsIgnoreCase("Large")) {
                    price = 3.0;
                }
                Drink drink = new Drink(name, size, price);
                order.add(drink);
                System.out.println(size + " " + name + " added to order.");
                System.out.println("Enter 0 to stop adding drinks. Any number to continue.");
                int moreDrinks = scanner.nextInt();
                scanner.nextLine();
                if (moreDrinks == 0) {
                    System.out.println("Moving on!");
                }
                exitBeverage = true;
            }
        }
        public void addChips () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Need that side of chips!");
            boolean exitChips = false;
            while (!exitChips) {
                String name = null;
                double price = 1.5;
                System.out.println("Which chips would you like?\n1-Doritos\n2-Lays\n3-Cheetos\n4-Pringles");
                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Invalid entry please try again");
                    continue;
                }
                int chipChoice = scanner.nextInt();
                scanner.nextLine();
                while (name == null) {
                    switch (chipChoice) {
                        case 1:
                            name = "Doritos";
                            System.out.println("Doritos selected.");
                            break;
                        case 2:
                            name = "Lays";
                            System.out.println("Lays selected.");
                            break;
                        case 3:
                            name = "Cheetos";
                            System.out.println("Cheetos selected.");
                            break;
                        case 4:
                            name = "Pringles";
                            System.out.println("Pringles selected.");
                            break;
                        default:
                            System.out.println("Invalid entry. Please choose a number 1-4.");
                    }
                }
                order.add(new Chip(name, price));
                System.out.println(name + " added to order");
                System.out.println("Enter 0 to stop adding chips. Enter any number to continue adding.");
                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Invalid entry please try again");
                    continue;
                }
                int moreChips = scanner.nextInt();
                if (moreChips == 0) {
                    System.out.println("Finalizing chip additions...");
                    exitChips = true;
                }
            }
    }
        public double getTotal() {
            double sum = 0.0;
            for (MenuItem item : order) {
                sum += item.getPrice();
            }
            return sum;
        }

        public List<MenuItem> getOrder () {
            return order;
        }
    }

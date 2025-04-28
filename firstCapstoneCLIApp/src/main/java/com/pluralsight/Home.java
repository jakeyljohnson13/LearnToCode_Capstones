package com.pluralsight;
import java.util.Scanner;

public class Home {
    Scanner s = new Scanner(System.in);

    public void homeScreen(){
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the financial tracker home screen.");
            System.out.println("Please select from the following options: ");
            System.out.println("D: Add deposit\n P: Make Payment\n L: Ledger\n X: Exit");
            String input = s.nextLine();
            if (input.equalsIgnoreCase("D")){
                addDeposit();
            }
            if (input.equalsIgnoreCase("P")){
                makePayment();
            }
            if (input.equalsIgnoreCase("X")){
                exit = true;
            }
        }
    }
    public void addDeposit(){
        System.out.println("Please enter the date: ");
        //Scanner allows for user date
        //To be updated as variables not yet created
        //Will likely need to be stored and written to transactions.csv
        System.out.println("Please enter the time: ");
        //same here
        System.out.println("Please provide a description:");
        //and here
        System.out.println("Please give the name of the vendor: ");
        //and here
        System.out.println("Please provide the amount deposited: ");
        //and here

        //Here we'll use a filewriter to add the info to the csv file
        //Use descriptive writing to make clear it's a deposit
    }
    public void makePayment(){
        System.out.println("Please enter your debit card number: ");
        String cardNum = s.nextLine();
        //Ensure entry of 16-digit numeric characters
        if ((cardNum.length() != 16) && cardNum.matches("\\d+")){
            System.out.println("Invalid Entry. Please try again.");
            while (cardNum.length() != 16 && cardNum.matches("\\d+")){
                System.out.println("Re-enter your debit card number: ");
                cardNum = s.nextLine();
            }
        }
        System.out.println("Please enter your 3-digit PIN");
        String cardPin = s.nextLine();
        if (cardPin.length() !=3 && cardPin.matches("\\d+")){
            System.out.println("Invalid Entry. Please Try again");
            while (cardPin.length() !=3 && cardPin.matches("\\d+")){
                System.out.println("Re-enter your debit PIN");
                cardPin = s.nextLine();
            }
        }
        System.out.println("Please enter the Account Holder's name: ");
        String cardName = s.nextLine();
        System.out.println("Please enter your billing address: ");
        String cardAddy = s.nextLine();

        //Use file writer to add this info to the csv file
    }
}

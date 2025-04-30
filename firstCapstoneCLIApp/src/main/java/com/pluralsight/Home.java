package com.pluralsight;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Home {
    Scanner s = new Scanner(System.in);
    //Create constructor and object to allow for adding to Entries Arraylist
    private Ledger ledger;
    public Home(Ledger ledger){
        this.ledger = ledger;
    }
    //Method to add transactions to Entries Arraylist
    public void addToEntries(Transactions transactions){
        ledger.addTransaction(transactions);
    }


    public void homeScreen(){
        boolean exit = false;
        while (!exit) {
            System.out.println();
            System.out.println("Welcome to the financial tracker home screen.");
            System.out.println("Please select from the following options: ");
            System.out.println("D: Add deposit\nP: Make Payment\nL: Ledger Menu\nX: Exit");
            String input = s.nextLine();
            if (input.equalsIgnoreCase("D")){
                addDeposit();
            }
            else if (input.equalsIgnoreCase("P")){
                makePayment();
            }
            else if (input.equalsIgnoreCase("L")){
                ledger.ledgerScreen();
            }
            else if (input.equalsIgnoreCase("X")){
                exit = true;
            }
        }
    }
    public void addDeposit(){
        LocalDate today = LocalDate.now();
        String todayString = today.toString();

        LocalTime now = LocalTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        String nowString = now.format(fmt);

        System.out.println("Please enter a description: ");
        String newDesc = s.nextLine();

        System.out.println("Please enter the vendor's name: ");
        String newVendor = s.nextLine();

        System.out.println("Please enter deposit amount: ");
        double depAmount = s.nextDouble();
        s.nextLine();

        Transactions newDeposit = new Transactions(todayString,nowString,newDesc,newVendor,depAmount);
        addToEntries(newDeposit);

        try {
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            fileWriter.write(newDeposit.getDate() + "|" + newDeposit.getTime() + "|" + newDeposit.getDescription() + "|" + newDeposit.getVendor() + "|" + newDeposit.getAmount() + "\n");
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void makePayment(){
        System.out.println("Please enter your debit card number: ");
        String cardNum = s.nextLine();
        //Ensure entry of 16-digit numeric characters
        if ((cardNum.length() != 16) || !cardNum.matches("\\d+")){
            System.out.println("Invalid Entry. Please try again.");
            while (cardNum.length() != 16 && cardNum.matches("\\d+")){
                System.out.println("Re-enter your debit card number: ");
                cardNum = s.nextLine();
            }
        }
        System.out.println("Please enter your 3-digit PIN");
        String cardPin = s.nextLine();
        if (cardPin.length() !=3 || !cardPin.matches("\\d+")){
            System.out.println("Invalid Entry. Please Try again");
            while (cardPin.length() !=3 && cardPin.matches("\\d+")){
                System.out.println("Re-enter your debit PIN");
                cardPin = s.nextLine();
            }
        }

        //Card Info
        System.out.println("Please enter the Account Holder's name: ");
        String cardName = s.nextLine();
        System.out.println("Please enter your billing address: ");
        String cardAddy = s.nextLine();
        System.out.println("Please enter the amount for the payment: ");
        double payAmount = s.nextDouble();
        if (payAmount > 0){
            payAmount = -1 * payAmount;
        }
        s.nextLine();

        //Create new variables to be added to new transaction object
        //These are necessary for adding the transaction to the ledger
        LocalDate today = LocalDate.now();
        String todayString = today.toString();

        LocalTime now = LocalTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        String nowString = now.format(fmt);

        System.out.println("Please enter a description: ");
        String newDesc = s.nextLine();

        System.out.println("Please enter the vendor's name: ");
        String newVendor = s.nextLine();

        //Creates new transaction object with user input
        //Then adds to Entries Arraylist
        Transactions newPayment = new Transactions(todayString,nowString,newDesc,newVendor,payAmount);
        addToEntries(newPayment);

        try {
            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(newPayment.getDate() + "|" + newPayment.getTime() + "|" + newPayment.getDescription() + "|" + newPayment.getVendor() + "|" + newPayment.getAmount() + "\n");
            writer.write("Payment info:\nAccount Holder: " + cardName + "\nBilling Address: " + cardAddy + "\nCard Number: \"" + cardNum + "\"\nCard Pin: " + cardPin + "\n");
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        }
    }

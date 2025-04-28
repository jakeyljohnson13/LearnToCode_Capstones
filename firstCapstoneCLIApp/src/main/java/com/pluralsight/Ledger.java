package com.pluralsight;
import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    //Make ledger private then create constructor
    //This allows for adding entries across classes
    private ArrayList<Transactions> Entries;
    public Ledger(){
        this.Entries = new ArrayList<>();
    }
    public ArrayList<Transactions> getEntries(){
        return Entries;
    }
    Transactions prompt = new Transactions("date","time","description","vendor",0.0);
    public void addTransaction(Transactions t){
        Entries.add(t);
    }
    public void addPrompt(){
        Entries.add(prompt);
    }
    Scanner s = new Scanner(System.in);


    public void displayAll(){
        for (Transactions t : Entries){
            System.out.println(getEntries());
        }
    }
    public void displayDeposits(){
        //Display deposits
        //Need file reader or buffered reader
        //Will need some constrictions
    }
    public void displayPayments(){
        //Display payments
        //Only negative entries
        //Need file reader or buffered reader
        //Will need some constrictions
    }
    public void ledgerScreen(){
        boolean ledgerExit = false;
        while (!ledgerExit){
        System.out.println("Welcome to the company ledger.");
        System.out.println("Please select from the following options: ");
        System.out.println("A: All deposits\n D: Deposits\n P: Payments\n R: Reports Menu");
        String command = s.nextLine();
        if (command.equalsIgnoreCase("A")){
            for (Transactions t : Entries){
                System.out.println(getEntries());
            }
        } else if (command.equalsIgnoreCase("D")) {
            for (Transactions t : Entries){
                if (t.getAmount() >= 0){
                    System.out.println(getEntries());
                }
            }
        } else if (command.equalsIgnoreCase("P")) {
            for (Transactions t : Entries){
                if (t.getAmount() < 0) {
                    System.out.println(getEntries());
                }
            }
        } else if (command.equalsIgnoreCase("R")) {
            //Create Method for reports menu
        } else if (command.equalsIgnoreCase("H")) {
            ledgerExit = true;
        }

    }







    public void Reports(){
        boolean reportsExit = false;
        while (!ledgerExit){
            System.out.println("Please choose from the following options: ");
            System.out.println("1: Month To Date\n 2: Previous Month\n 3: Year to date\n 4: Previous Year\n 5: Search by Vendor\n 0: Back");
            int ledgerInput;
            ledgerInput = s.nextInt();
            if (ledgerInput == 0){
                ledgerExit = true;
            }
        }
    }
}

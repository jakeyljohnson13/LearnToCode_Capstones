package com.pluralsight;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //Creating objects so as to be able to reference other classes
        Ledger ledger = new Ledger();
        Home start = new Home(ledger);

        //Determine whether file exists so as to not overwrite ledger
        String fileName = "transactions.csv";
        File file = new File(fileName);
        //Initialize with prompt if no such file exists (making these the first entries)
        if (!file.exists() || !file.canRead()) {
            try {
                FileWriter writer = new FileWriter("transactions.csv");
                writer.write("Date|Time|Description|Vendor|Amount\n");
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        } //Initialize previous ledger if file is available
        else {
            try {
                FileReader reader = new FileReader("transactions.csv");
                BufferedReader br = new BufferedReader(reader);
                br.readLine();
                String input;
                while ((input = br.readLine()) != null) {
                    //System.out.println(input);
                    String[] parts = input.split("\\|");
                    if (parts.length == 5) {
                        String oldDate = parts[0];
                        String oldTime = parts[1];
                        String oldDesc = parts[2];
                        String oldVen = parts[3];
                        String amtString = parts[4];
                        double oldAmt = Double.parseDouble(amtString);
                        Transactions olderStuff = new Transactions(oldDate, oldTime, oldDesc, oldVen, oldAmt);
                        ledger.addTransaction(olderStuff);
                    }
                }
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        start.homeScreen();
    }
}
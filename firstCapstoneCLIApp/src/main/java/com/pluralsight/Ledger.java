package com.pluralsight;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    //Make ledger private then create constructor
    //This allows for adding entries across classes
    private ArrayList<Transactions> Entries;

    public Ledger() {
        this.Entries = new ArrayList<>();
    }

    public ArrayList<Transactions> getEntries() {
        return Entries;
    }

    Transactions prompt = new Transactions("date", "time", "description", "vendor", 0.0);

    public void addTransaction(Transactions t) {
        Entries.add(t);
    }
    Scanner s = new Scanner(System.in);


    public void displayAll() {
        for (Transactions t : Entries) {
            System.out.printf("%s|%s|%s|%s|%.2f\n",
                    t.getDate(),
                    t.getTime(),
                    t.getDescription(),
                    t.getVendor(),
                    t.getAmount());
        }
    }

    public void displayDeposits() {
        for (Transactions t4 : Entries){
            if (t4.getAmount() >= 0){
                System.out.printf("%s|%s|%s|%s|%.2f\n",
                    t4.getDate(),
                    t4.getTime(),
                    t4.getDescription(),
                    t4.getVendor(),
                    t4.getAmount());
            }
        }
    }

    public void displayPayments() {
        for (Transactions t5 : Entries) {
            if (t5.getAmount() < 0) {
                System.out.printf("%s|%s|%s|%s|%.2f\n",
                        t5.getDate(),
                        t5.getTime(),
                        t5.getDescription(),
                        t5.getVendor(),
                        t5.getAmount());
            }
        }

    }
        public void ledgerScreen () {
            boolean ledgerExit = false;
            while (!ledgerExit) {
                System.out.println();
                System.out.println("Welcome to the company ledger.");
                System.out.println("Please select from the following options: ");
                System.out.println("A: All deposits\nD: Deposits\nP: Payments\nR: Reports Menu");
                String command = s.nextLine();
                if (command.equalsIgnoreCase("A")) {
                    displayAll();
                } else if (command.equalsIgnoreCase("D")) {
                    displayDeposits();
                } else if (command.equalsIgnoreCase("P")) {
                    displayPayments();
                } else if (command.equalsIgnoreCase("R")) {
                    Reports();
                } else if (command.equalsIgnoreCase("H")) {
                    ledgerExit = true;
                }
            }
        }

        public void Reports(){
            boolean reportsExit = false;
            while (!reportsExit) {
                System.out.println();
                System.out.println("Please choose from the following options: ");
                System.out.println("1: Month To Date\n2: Previous Month\n3: Year to date\n4: Previous Year\n5: Search by Vendor\n0: Back");
                LocalDate date = LocalDate.now();
                int ledgerInput;
                ledgerInput = s.nextInt();
                switch (ledgerInput) {
                    case 0:
                        reportsExit = true;
                        break;
                    case 1:
                        for (Transactions tr : Entries) {
                            String monthSort = String.valueOf(date.getMonth());
                            if (tr.getDate().contains(monthSort)) {
                                System.out.println(tr);
                            }

                        }
                        break;
                    case 2:
                        for (Transactions tr : Entries) {
                            LocalDate currentMonth = LocalDate.from(date.getMonth());
                            System.out.println(currentMonth);
                            LocalDate previousMonth = currentMonth.minusMonths(1);
                            System.out.println(previousMonth);
                            String lastMonthString = String.valueOf(previousMonth);
                            System.out.println(lastMonthString);
                            if (tr.getDate().contains(lastMonthString)) {
                                System.out.println(tr);
                            }

                        }
                        break;
                    case 3:
                        for (Transactions transactions : Entries) {
                            String currentYear = String.valueOf(date.getYear());
                            if (transactions.getDate().contains(currentYear)) {
                                System.out.println(transactions);
                            }
                        }
                        break;
                    case 4:
                        for (Transactions t1 : Entries) {
                            int lastYear = date.getYear() - 1;
                            String lastYearString = String.valueOf(lastYear);
                            if (t1.getDate().contains(lastYearString)) {
                                System.out.println(t1);
                            }
                        }
                        break;
                    case 5:
                        String searchVendor = s.nextLine();
                        for (Transactions t2 : Entries) {
                            if (searchVendor.equalsIgnoreCase(t2.getVendor())) {
                                System.out.println(t2);
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid Entry. Please try again.");
                        break;
                }
            }
        }
    }


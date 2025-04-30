package com.pluralsight;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                System.out.println("A: All deposits\nD: Deposits\nP: Payments\nR: Reports Menu\nH: Home");
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
                LocalDate current = LocalDate.now();
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM");
                int ledgerInput;
                ledgerInput = s.nextInt();
                s.nextLine();
                switch (ledgerInput) {
                    case 0:
                        reportsExit = true;
                        break;
                    case 1:
                        String monthSort = current.format(fmt);
                        for (Transactions tr : Entries) {
                            if (tr.getDate().startsWith(monthSort)) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        tr.getDate(),
                                        tr.getTime(),
                                        tr.getDescription(),
                                        tr.getVendor(),
                                        tr.getAmount());
                            }
                        }
                        break;
                    case 2:
                        for (Transactions tr : Entries) {
                            LocalDate previousMonth = current.minusMonths(1);
                            String lastMonthString = previousMonth.format(fmt);
                            if (tr.getDate().startsWith(lastMonthString)) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        tr.getDate(),
                                        tr.getTime(),
                                        tr.getDescription(),
                                        tr.getVendor(),
                                        tr.getAmount());                            }
                        }
                        break;
                    case 3:
                        DateTimeFormatter yr = DateTimeFormatter.ofPattern("yyyy");
                        for (Transactions tr : Entries) {
                            String currentYear = current.format(yr);
                            if (tr.getDate().startsWith(currentYear)) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        tr.getDate(),
                                        tr.getTime(),
                                        tr.getDescription(),
                                        tr.getVendor(),
                                        tr.getAmount());;
                            }
                        }
                        break;
                    case 4:
                        for (Transactions tr : Entries) {
                            int lastYear = current.getYear() - 1;
                            String lastYearString = String.valueOf(lastYear);
                            if (tr.getDate().contains(lastYearString)) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        tr.getDate(),
                                        tr.getTime(),
                                        tr.getDescription(),
                                        tr.getVendor(),
                                        tr.getAmount());
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Enter the name of the vendor:");
                        String searchVendor = s.nextLine();
                        for (Transactions tr : Entries) {
                            if (searchVendor.equalsIgnoreCase(tr.getVendor())) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        tr.getDate(),
                                        tr.getTime(),
                                        tr.getDescription(),
                                        tr.getVendor(),
                                        tr.getAmount());
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


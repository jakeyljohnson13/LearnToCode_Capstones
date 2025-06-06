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
    public void addTransaction(Transactions t) {
        Entries.add(t);
    }
    Scanner s = new Scanner(System.in);


    public void displayAll() {
        for (int i = Entries.size() - 1; i>=0; i--) {
            System.out.printf("%s|%s|%s|%s|%.2f\n",
                    Entries.get(i).getDate(),
                    Entries.get(i).getTime(),
                    Entries.get(i).getDescription(),
                    Entries.get(i).getVendor(),
                    Entries.get(i).getAmount());
        }
    }

    public void displayDeposits() {
        for (int i = Entries.size() - 1; i>=0; i--){
            if (Entries.get(i).getAmount() >= 0){
                System.out.printf("%s|%s|%s|%s|%.2f\n",
                        Entries.get(i).getDate(),
                        Entries.get(i).getTime(),
                        Entries.get(i).getDescription(),
                        Entries.get(i).getVendor(),
                        Entries.get(i).getAmount());
            }
        }
    }

    public void displayPayments() {
        for (int i = Entries.size() - 1; i>=0; i--) {
            if (Entries.get(i).getAmount() < 0) {
                System.out.printf("%s|%s|%s|%s|%.2f\n",
                        Entries.get(i).getDate(),
                        Entries.get(i).getTime(),
                        Entries.get(i).getDescription(),
                        Entries.get(i).getVendor(),
                        Entries.get(i).getAmount());
            }
        }

    }
        public void ledgerScreen () {
            boolean ledgerExit = false;
            while (!ledgerExit) {
                System.out.println();
                System.out.println("Welcome to the company ledger.");
                System.out.println("Please select from the following options: ");
                System.out.println("A: All transactions\nD: Deposits\nP: Payments\nR: Reports Menu\nH: Home");
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
                        for (int i = Entries.size() - 1; i>=0;i--) {
                            if (Entries.get(i).getDate().startsWith(monthSort)) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        Entries.get(i).getDate(),
                                        Entries.get(i).getTime(),
                                        Entries.get(i).getDescription(),
                                        Entries.get(i).getVendor(),
                                        Entries.get(i).getAmount());
                            }
                        }
                        break;
                    case 2:
                        for (int i = Entries.size() - 1; i>=0;i--) {
                            LocalDate previousMonth = current.minusMonths(1);
                            String lastMonthString = previousMonth.format(fmt);
                            if (Entries.get(i).getDate().startsWith(lastMonthString)) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        Entries.get(i).getDate(),
                                        Entries.get(i).getTime(),
                                        Entries.get(i).getDescription(),
                                        Entries.get(i).getVendor(),
                                        Entries.get(i).getAmount());                            }
                        }
                        break;
                    case 3:
                        DateTimeFormatter yr = DateTimeFormatter.ofPattern("yyyy");
                        for (int i = Entries.size() - 1; i>=0;i--) {
                            String currentYear = current.format(yr);
                            if (Entries.get(i).getDate().startsWith(currentYear)) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        Entries.get(i).getDate(),
                                        Entries.get(i).getTime(),
                                        Entries.get(i).getDescription(),
                                        Entries.get(i).getVendor(),
                                        Entries.get(i).getAmount());;
                            }
                        }
                        break;
                    case 4:
                        for (int i = Entries.size() - 1; i>=0;i--) {
                            int lastYear = current.getYear() - 1;
                            String lastYearString = String.valueOf(lastYear);
                            if (Entries.get(i).getDate().contains(lastYearString)) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        Entries.get(i).getDate(),
                                        Entries.get(i).getTime(),
                                        Entries.get(i).getDescription(),
                                        Entries.get(i).getVendor(),
                                        Entries.get(i).getAmount());
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Enter the name of the vendor:");
                        String searchVendor = s.nextLine();
                        for (int i = Entries.size() - 1; i>=0;i--) {
                            if (searchVendor.equalsIgnoreCase(Entries.get(i).getVendor())) {
                                System.out.printf("%s|%s|%s|%s|%.2f\n",
                                        Entries.get(i).getDate(),
                                        Entries.get(i).getTime(),
                                        Entries.get(i).getDescription(),
                                        Entries.get(i).getVendor(),
                                        Entries.get(i).getAmount());
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


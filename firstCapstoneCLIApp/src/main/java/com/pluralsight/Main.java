package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Ledger ledger = new Ledger();
        Home start = new Home(ledger);
        start.homeScreen();
    }
}
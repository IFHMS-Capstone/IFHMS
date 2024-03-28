package com.factory;

public class Report implements Document{
    @Override
    public void displayInfo() {
        System.out.println("This is a report document.");
    }
}

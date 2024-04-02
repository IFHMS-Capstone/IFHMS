package com.Models;

public class Patient {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public int age;

    public Patient(String firstName, String lastName, String phoneNumber, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public void displayPatientRoles(){
        System.out.println(".....PATIENT INTEREST........ ");
        System.out.println("1.Book appointment ");
        System.out.println("2.Pay bills");

    }
}
